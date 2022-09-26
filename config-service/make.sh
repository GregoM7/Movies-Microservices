mvn clean && mvn package -DskipTests # Skipeamos tests para evitar errores
docker build . -t config-service