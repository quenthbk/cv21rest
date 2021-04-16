import React from 'react';

import {CVResume} from './CVResume'

import Api from 'services/api/CV21Rest'

import { Alert } from 'react-bootstrap'

class CVList extends React.Component {
  constructor(props) {
    super(props)
    this.handleResponse = this.handleResponse.bind(this)
  }
  
  state = {
    cvs: [],
    message: '',
    error: false
  }

  componentDidMount() {
    Api.get(`resume`)
      .then(res => {
        this.handleResponse(res.data)
      })
      .catch(e => {
        console.log(e)
        const message = "Une erreur est survenue"
        this.setState({ message: message, error: true })
      })
  }

  handleResponse(xmlText) {
    var XMLParser = require('react-xml-parser');
    var xml = new XMLParser().parseFromString(xmlText);
    var cvs = [];
    xml.children.forEach(child => {
        let cv = {
          id: child.attributes.id,
          firstname: child.getElementsByTagName('prenom')[0].value,
          lastname: child.getElementsByTagName('nom')[0].value,
          objective: child.getElementsByTagName('objectif')[0]
        }

        cvs.push(cv)
      }
    )
    this.setState({ cvs: cvs, error: false })
  }

  render() {
    var alert = ''
    if (this.state.error) {
      alert = <Alert variant={'danger'}>
      { this.state.message }
    </Alert>
    }
    return (
      <div className="cv-list">
        { alert }
        { this.state.cvs.map(cv => <CVResume
            key={cv.id}
            {...cv}
          />)
        }
      </div>
    );
  }
}

export { CVList };
