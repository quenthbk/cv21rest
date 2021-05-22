# CV21Rest

- depot du client : https://github.com/quentinholubeik/cv21-webapp

## API

### Développement

- Pour développer vous aurez besoin de votre éditeur préféré (intelliJ ou Eclipse de préférence)
- Le schema correspondant à la norme CV21 est situé dans le dossier `src/main/resources/static/schema`
- Quelques fichier xml de tests sont présent dans le dossier `src/resources`
- Déployez la base de donné avec docker en éxécutant le script `bash database/db_run.sh`

### Deploiement en local

- `mvn spring-boot:run` pour exécuter l'application et effectuers vos tests scénarios
- `bash database/db_run.sh` pour déployer une base de donnée mongo éphémère avec **docker**
- Une collection de scénario **Postman** est disponible dans le dossier resources
- Par défaut le port de l'api est `8080` et celui de la base de donnée `27017`
- L'identifiant de la base de donnée par défaut est `root`
- Le mot de passe de la base de donnée par défaut est `root`

### Deploiement production

- La mise en production se fait par l'intermédiaire d'un git push sur la branche master
- Un profil clevercloud a été défini dans spring boot
