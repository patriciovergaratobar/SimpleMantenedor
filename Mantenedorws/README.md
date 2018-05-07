# Mantenedor WS
Ejemplo con RestEasy y MongoDB

A continuación dejo los apuntes para iniciar MongoDB.

```sh
#Apuntes
#Instalar mongo
docker pull mongo

docker run --name some-mongo -p 27017:27017 -d mongo

#conectar desde una aplicación
$ docker run --name some-app --link some-mongo:mongo -d application-that-uses-mongo

#Configuración
docker run --name some-mongo -d mongo --storageEngine wiredTiger

#Iniciar base de datos
$ docker run --name some-mongo -d mongo --auth


#Crear usuario
docker exec -it some-mongo mongo admin

db.createUser({
    user: 'pvergara',
    pwd: '123456',
    roles: [{
        role: "userAdminAnyDatabase",
        db: "admin"
    }]
});

 docker run -it --rm --link some-mongo:mongo mongo mongo -u pvergara -p 123456 --authenticationDatabase admin some-mongo/some-db
 
docker pull mongo-express
docker run --link some-mongo:mongo -p 8081:8081 mongo-express
```