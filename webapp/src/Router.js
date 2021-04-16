import { BrowserRouter } from "react-router-dom";

import  { Menu } from 'components/Menu/Menu'
import  { App } from './App'

const Router = () => {
  return (
    <BrowserRouter>
        <Menu />
        <App />
    </BrowserRouter>
  );
}

export default Router;
