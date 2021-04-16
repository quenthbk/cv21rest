import React from 'react'
import {Navbar, Nav, Form, FormControl, Button} from 'react-bootstrap'
import {LinkContainer as Link} from 'react-router-bootstrap'

class Menu extends React.Component {
    constructor(props) {
        super(props)
        this.handleChange = this.handleChange.bind(this)

        this.state = {
            id: ''
        }
    }

    handleChange(e) {
        this.setState({id : e.target.value})
    }

    render() { 
        return (<Navbar bg="dark" variant="dark">
            <Navbar.Brand href="">CV21</Navbar.Brand>
            <Nav className="mr-auto">
                <Link exact to="/">
                    <Nav.Link>Accueil</Nav.Link>
                </Link>
                <Link to="/resume">
                    <Nav.Link>Liste des CVs</Nav.Link>
                </Link>
                <Link to="/cv">
                    <Nav.Link>Enregistrer un CV</Nav.Link>
                </Link>
            </Nav>
            <Form inline>
                <FormControl type="text" placeholder="ID du CV" className="mr-sm-2" value={this.state.id} onChange={this.handleChange} />
                <Link to={"/cv/" + this.state.id}>
                    <Button variant="outline-info">Search</Button>
                </Link>
            </Form>
        </Navbar>
        )
    }
}

export {Menu}