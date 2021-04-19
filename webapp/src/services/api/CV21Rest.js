import axios from 'axios';

export default axios.create({
  baseURL: process.env.REACT_APP_API_BASE,
  headers: {
    "Content-Type": "application/xml",
    "accept": "application/xml"
}
});
