mvn clean && mvn package -DskipTests # Skipeamos tests
docker build . -t gateway-service