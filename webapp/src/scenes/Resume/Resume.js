
import { CVList } from "components/CVList/CVList"

import { Card } from "react-bootstrap"

function Resume() {
  return (
    <Card>
      <Card.Header>Liste des CV existants</Card.Header>
      <Card.Body> <CVList /> </Card.Body>
    </Card>
  );
}

export { Resume };
