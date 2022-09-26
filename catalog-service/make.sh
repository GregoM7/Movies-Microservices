mvn clean && mvn package -DskipTests
docker-compose up
docker build . -t movie-service