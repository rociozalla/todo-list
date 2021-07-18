# Todo-list
Code challenge

Requisitos: Instalar Java 11 y utilizar algun cliente HTTP para testeo como, por ejemplo, Postman.
Al utilizar Postman es posible:
- crear un item nuevo por medio de POST, con el siguiente url `http://localhost:8080/api/v1/todo`, clickeando Body, raw y JSON. Como ejemplo se puede utilizar: `{
    "userName": "Rocio",
    "description": "Buy food",
    "folder": "food",
    "completed": false
}`
- obtener un item por medio de GET, con el siguiente url `http://localhost:8080/api/v1/todo/{id}`
- obtener todos los items por medio de GET, con el siguiente url `http://localhost:8080/api/v1/todo/items`
- actualizar un item por medio de PATCH, con el siguiente url `http://localhost:8080/api/v1/todo`, clickeando Body, raw y JSON. Como ejemplo se puede utilizar: ` {
    "id": 7,
    "description": "Cook dinner",
    "completed": true
}` cuyo resultando, dependiendo de la existencia o no del item sera el item modificado o bien: `{
    "timestamp": "2021-07-16T01:26:23.533+00:00",
    "status": 404,
    "error": "Not Found",
    "path": "/api/v1/todo"
}`
- eliminar un item por medio de DELETE, con el siguiente url `http://localhost:8080/api/v1/todo/{id}`, clickeando Body, raw y JSON, cuyo resultando, dependiendo de la existencia o no del item sera la eliminacion del mismo o bien: `{
    "timestamp": "2021-07-16T14:29:18.328+00:00",
    "status": 404,
    "error": "Not Found",
    "path": "/api/v1/todo/{id}"
}`
