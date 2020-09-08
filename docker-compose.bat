echo "### Compilation mvn ###"
mvn clean package

echo "### Execution docker-compose ###"
docker-compose up -d --build