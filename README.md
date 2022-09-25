# my-email-api Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application with Postgres docker container

In project root folder run:
```shell script
./gradlew build
```
to build quarkus application, then build docker-compose file using command:
```shell script
docker-compose build
```
Now, docker containers are ready to be started (use "-d" to enter detached mode):
```shell script
docker-compose up [-d]
```
To stop and remove docker containers run:
```shell script
docker stop my-email-api-container my-email-api-db-container || true && docker rm my-email-api-container my-email-api-db-container || true
```
To check docker containers and their current status run:
```shell script
docker ps -a
```

## Related Guides

- SmallRye JWT Build ([guide](https://quarkus.io/guides/security-jwt-build)): Create JSON Web Token with SmallRye JWT Build API
- SmallRye JWT ([guide](https://quarkus.io/guides/security-jwt)): Secure your applications with JSON Web Token
