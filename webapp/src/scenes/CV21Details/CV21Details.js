import React from 'react';

import Api from 'services/api/CV21Rest';

import { Card, Button, ButtonGroup } from 'react-bootstrap'

import { CVForm } from "components/CVForm/CVForm"

import XMLViewer from 'react-xml-viewer'

import beautify from 'prettify-xml';


class CV21Details extends React.Component {
  constructor(props) {
    super(props)
    this.handleButton = this.handleButton.bind(this)
    this.handleSave = this.handleSave.bind(this)
    this.handleDelete = this.handleDelete.bind(this)

    this.id = props.match.params.id
    this.state = {
      cvxml: '',
      found: false,
      editing: false,
      message: ''
    }
  }

  componentDidMount() {
    Api.get(`cv`, { params : {id: this.id }})
      .then(res => {
        this.setState({ cvxml: res.data, found: true })
      })
      .catch(e => {
        var message
        if (e.response !== undefined && e.response.status === 404) {
          message =  "Le CV n'a pas été trouvé"
        } else {
          message = "Une erreur est survenue"
        }
        this.setState({ message: message, found: false })
    })
  }

  handleButton(e) {
    this.setState({editing : true})
  }

  handleSave(value) {
    this.setState({editing : false, cvxml: value})
  }

  handleDelete(e) {
    Api.delete(`delete`, { params : {id: this.id }}).then(data => {
      this.setState({ found: false, message: 'Le CV a correctement été supprimé' })
    })
    .catch(e => {
      const message = "Une erreur est survenue"
      this.setState({ message: message})
    })
  }

  render() {
    var finalRender
    if (this.state.found) {
      if (this.state.editing) {
        const cvxml = beautify(this.state.cvxml)
        finalRender = <CVForm key={ this.id } value={ cvxml } update={ true } id={this.id} onChange={this.handleSave}/>
      } else {
        finalRender = (<div>
          <XMLViewer key={ this.id } xml={this.state.cvxml} indentSize={8} />
          <ButtonGroup>
            <Button variant="success" onClick={this.handleButton}>Modifier</Button>
            <Button variant="danger" onClick={this.handleDelete}>Supprimer</Button>
          </ButtonGroup>
        </div>
        )
      }
    } else {
      finalRender = <p>{ this.state.message }</p>
    }
    return (
    <Card>
      <Card.Header>Details du CV existant</Card.Header>
      <Card.Body> { finalRender }</Card.Body>
    </Card>
    )
  }
}

export { CV21Details };
