import './App.css';

import { Container } from 'react-bootstrap'
import { Index } from 'scenes/Index/Index'
import { CV21 } from 'scenes/CV21/CV21'
import { CV21Details } from 'scenes/CV21Details/CV21Details'
import { Resume } from 'scenes/Resume/Resume'



import { Switch, Route } from "react-router-dom";

function App() {
  return (
    <Container className="wrap">
        <Switch>
          <Route exact path="/cv" component={ CV21 } />
          <Route exact path="/cv/:id" component={ CV21Details } />
          <Route exact path="/resume" component={ Resume } />
          <Route path="/" component={ Index } />
        </Switch>
    </Container>
  );
}

export { App };
