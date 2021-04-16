import React from 'react';

import Api from 'services/api/CV21Rest';

import { Form, Button, Alert } from 'react-bootstrap'

/**
 * Composant représentant le formulaire d'un CV
 * 
 * @param value Le CV au format XML
 * @param update Indique si le formulaire doit mettre à jour le CV (true) 
 *    ou le créer (false)
 */
class CVForm extends React.Component {
  constructor(props) {
    super(props);
    var value = ''
    this.update = false
    this.id = ''
    this.onChange = props.onChange

    if (typeof props.value !== undefined) {
      value = props.value
    }

    if (typeof props.update !== undefined) {
      this.update = props.update
    }

    if (typeof props.id !== undefined) {
      this.id = props.id
    }

    this.state = {
      value: value,
      message: '',
      error: false
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({value: event.target.value});
  }

  handleSubmit(event) {
    Api({
      method: this.update ? 'put' : 'post',
      url: this.update ? 'update' : 'insert',
      data: this.state.value,
      params : this.update ? {id: this.id} : {}
    })
    .then(data => {
      this.setState({message : "CV Bien enregistré"})
      if (typeof this.onChange != undefined) {
        this.onChange(this.state.value)
      }
      this.setState({error: false})
    })
    .catch(e => {
      if (e.response) {
        this.setState({error: false})
        var response = e.response.data
        var XMLParser = require('react-xml-parser');
        var message = "Une erreur s'est produite"
        try {
          var xml = new XMLParser().parseFromString(response);
          var message = xml.getElementsByTagName("message")[0]
          
        } catch (e) {
          console.error(e)
        }
        this.setState({message: message.value, error: true})
      }
    })
    //alert('Le cv a été soumis : ' + this.state.value)
    event.preventDefault();
  }

  render() {
    var alert = ''
    if (this.state.error) {
      alert = <Alert variant={'danger'}>
      { this.state.message }
    </Alert>
    }
    return (
      <Form onSubmit={this.handleSubmit}>
        { alert }
        <Form.Group controlId="exampleForm.ControlTextarea1">
          <Form.Label>Votre CV :</Form.Label>
          <Form.Control as="textarea" rows={3} value={this.state.value} onChange={this.handleChange} />
        </Form.Group>
        <Button variant="primary" type="submit">
            Sauvegarder
        </Button>
      </Form>
    )
  }

  /*
  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <p>{ this.state.message }</p>
        <label>CV21 XML :</label>
            <textarea value={this.state.value} onChange={this.handleChange} />
        <input type="submit" value="Sauvegarder" />
      </form>
    );
  }
  */
}

export { CVForm };
