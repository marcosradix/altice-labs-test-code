## documentation
localhost:8080/q/swagger-ui/

## create docker image
docker build -t altice .

## see docker image
docker images

## run docker container
docker run -p 8080:8080 <IMAGE ID>

## run without docker
mvn quarkus:dev


