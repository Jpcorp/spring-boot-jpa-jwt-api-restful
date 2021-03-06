# spring-boot-jpa-jwt-api-restful

_Aplicaci贸n API Restful, que expone la creacion de usuarios desarrollada con framerwork spring-boot persistencia a BD h2, con autenticaci贸n en JWT._

## Comenzando 馃殌

_El proyecto contiene los siguientes directorios_
 
- controllers : encargada de responder a eventos e invocaci贸n de peticiones a las distintas capas de la aplicaci贸n
- exceptions  : manejo de excepciones controladas por la aplicaci贸n
- models      : archivos que representan clases centradas en encapsular elementos ligados a representaci贸n de datos
- repositories: archivo central estandar para atender consultas a los datos
- security    : archivos para securizar un API Rest esta implementaci贸n con JWT para la generaci贸n de token
- services    : archivos que implemetan la logica de la aplicaci贸n
- validator   : archivos que implemetan validaciones
 
### Pre-requisitos 馃搵

_La aplicaci贸n API Restful construida con la herramienta Apache Maven_

```
mvn clean install
```
### Instalaci贸n 馃敡

_Para instalar al aplicaci贸n_

```
mvnw.cmd spring-boot:run
```
Para la ejecuci贸n de la Api Rest.

```
localhost:8090
```
