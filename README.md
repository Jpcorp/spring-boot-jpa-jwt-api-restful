# spring-boot-jpa-jwt-api-restful

_Aplicación API Restful, que expone la creacion de usuarios desarrollada con framerwork spring-boot con autenticación en JWT._

## Comenzando 🚀

_El proyecto contiene los siguientes directorios_
 
- controllers : encargada de responder a eventos e invocación de peticiones a las distintas capas de la aplicación
- exceptions  : manejo de excepciones controladas por la aplicación
- models      : archivos que representan clases centradas en encapsular elementos ligados a representación de datos
- repositories: archivo central estandar para atender consultas a los datos
- security    : archivos para securizar un API Rest esta implementación con JWT para la generación de token
- services    : archivos que implemetan la logica de la aplicación
- validator   : archivos que implemetan validaciones
 
### Pre-requisitos 📋

_La aplicación API Restful construida con la herramienta Apache Maven_

```
mvn clean install
```
### Instalación 🔧

_Para instalar al aplicación_

```
mvnw.cmd spring-boot:run
```
Para la ejecución de la Api Rest.

```
localhost:8090
```
