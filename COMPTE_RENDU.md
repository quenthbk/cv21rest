# Compte rendu CVRest21 Projet XML

- Quentin Holubeik
- email : `quentin.holubeik@etu.univ-rouen.fr`
- Depôt GitHub Api : `https://github.com/quentinholubeik/cv21rest.git`
- Depôt GitHub Client : `https://github.com/quentinholubeik/cv21-webapp`
- Instance Clevercloud : `http://app-cd3c9847-3e85-4c3f-83bb-1f1fae7844d2.cleverapps.io/`

## Intruduction

Le projet contient une api REST permettant de sauvegarder une bibliothèque de CV respectant la norme du schéma cv21.xsd. Un client React est fourni afin de rendre l'utilisation de cette api plus attractive. Ce rapport contient une description de l'application ainsi que les choix technologiques utilisés.

## Choix Technologiques

### L'Api Rest

L'Api Rest utilise le framework SpringBoot et est programmé en Java. Cette technologie a l'avantage d'être facilement compréhensible et accélère le temps de développement. De plus Maven permet de gérer des dépendances avec un large choix fourni par leur dépôt central. Voici les dépendances utilisées par l'application:
- spring-boot-starter-web
Permet d'utiliser les annotations et de faciliter le développement d'un service web.
- spring-boot-starter-security
Est configuré pour filtrer les requêtes CORS envoyé par le client
- spring-boot-starter-validation
M'a permis de tester les validations avant d'utiliser cv21.xsd
- spring-boot-starter-thymeleaf
Permet de fournir des modèles afin de construire les pages html de l'application.
- org.modelmapper
Transforme les objets DTO en modèle correspondant à l'architecture de l'application.
- com.fasterxml.jackson.dataformat
Permet de convertir un flux XML d'entré en Objet DTO et inversement pour les réponses.
- springfox-boot-starter
Permet d'avoir une documentation convenable sur les routes de l'api. Elle permet d'avoir une page d'aide propre et générée automatiquement.
- spring-boot-starter-test (junit 5)
Permet de préparer le terrain pour fournir les tests adéquates.

### Le Client
Le client quand à lui est développé en JavaScript avec le framework React Js et BootStrap.

### Le gestionnaire de Base de Donnée

Pour le gestionnaire de la base de données j'ai préféré utiliser mongodb plutôt qu'une autre technologie. Mongo est très souple et la partie NO-SQL correspond parfaitement au besoin de "bibliothèque" et d'"archivage" de donnée sans utiliser de quelconques relations. Aucune table n'est donc fournie.

### La Documentation via Springfox

La page d'aide redirige automatiquement vers l'uri de la documentation Swagger. Toutes les routes y sont spécifiées ainsi que les modèles DTO. Une description de chaque route et des éléments données en paramètres y sont spécifiés (ainsi que les critères de validation).

- **BUG**: Cependant Swagger via SpringFox gère mal le format XML et affiche des exemples du modèle non conforme au CV21.

## Notice de déploiement

Une notice de déploiement est intégrée pour chaque projet dans le fichier README.md

## Structure du modèle CV21

La structure de modèle CV21 est exposée avec des objets de transfères de données. Ils reprennent la configuration CV21 afin de correctement formater le format XML qui arrive en entrée. Une fois validé, ces DTO sont convertis dans un model plus approprié.

## Validation xsd

Le flux d'entré est validé avec SAXParser. Avant de pouvoir l'utilisé le parser doit être configuré avec le document se situant dans le dossier `src/main/resources/static/schema/cv21.xsd`. L'objet DTO est ensuite converti en model avec le framework modelmapper.

## Gestion des erreurs et des routes

Les erreurs sont attrapées par le Controller Advice défini dans le package `fr.univ.rouen.cv21rest.controller`.
Les routes concernant le CV sont définies dans le CVController. Les routes propre à l'application sont définies dans HomeController.

## Et Après

- La sécurité doit être mise en place pour accéder à l'application. Spring Boot Security permet d'effectuer ce cheminement. Pour le développement à venir il est possible d'utiliser les JWT token afin de sécuriser cela. Il est aussi possible d'utiliser un autre service (KeyCloak) qui permet le référencement des utilisateurs et la validation des token à la place du service Rest déjà existant. Mais cela serait plus rapport avec la matière "Architecture Distribuée"

- Les tests peuvent être développés avec junit5. Quelques tests ont été écris pour valider quelques comportements.

- La gestion des erreurs est parciellement développée et peut être améliorée.
