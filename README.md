# CV21Rest

## API

### Développement

- Pour développer vous aurez besoin de votre éditeur préféré (intelliJ ou Eclipse de préférence)
- Le schema correspondant à la norme CV21 est situé dans le dossier `src/main/resources/static/schema`
- Quelques fichier xml de tests sont présent dans le dossier `src/main/resources/static`

### Deploiement en local

- `mvn spring-boot:run` pour exécuter l'application et effectuers vos tests scénarios
- `bash database/db_run.sh` pour déployer une base de donnée mongo éphémère avec **docker**
- Une collection de scénario **Postman** est disponible dans le dossier resources
- Par défaut le port de l'api est `8080` et celui de la base de donnée `27017`
- L'identifiant de la base de donnée par défaut est `root`
- Le mot de passe de la base de donnée par défaut est `root`

## WebApp (Le Client)

### Développement sur l'api clevercloud

- Un client React est fourni dans le dossier `webapp`
- Placez vous à la racine du dossier `webapp`
- Éxecutez votre environnement de développement avec `npm run start`, le serveur par défaut npm tournera sous le port `3000`
- Par défaut l'adresse de l'api est réglé sur `http://app-cd3c9847-3e85-4c3f-83bb-1f1fae7844d2.cleverapps.io/`

### Développement sur l'api en local
- Éxecutez votre environnement de développement avec `npm run local`, le serveur par défaut npm tournera sous le port `3000`
- Par défaut l'adresse de l'api est réglé sur `localhost:8080` (adresse à modifier dans package.json)

### Deploiement en production

- Placez vous à la racine du dossier `webapp`
- `npm build` pour construire l'application pour la production
- Un dossier `build` sura alors créé contenant l'application construite
- L'application peut maintenant fonctionner avec un serveur applicatif
