
import './CVResume.css';
import { ListGroup } from 'react-bootstrap';

import {LinkContainer as Link} from 'react-router-bootstrap'

function CVResume(props) {
  console.log(props)
  return <Link to={'/cv/' + props.id}><ListGroup as="ul" className="cv-resume">
    <ListGroup.Item as="li">
      {props.firstname} {props.lastname}
    </ListGroup.Item>
    <ListGroup.Item as="li">{props.objective.name} : ({props.objective.attributes.statut}) {props.objective.value}</ListGroup.Item>
  </ListGroup></Link>
}

export { CVResume };