

function Index() {
  return (
      <div>
        <p>Bienvenue !</p>
        <p>Adresse de l'api : { process.env.REACT_APP_API_BASE }</p>
      </div>
  );
}

export { Index };
