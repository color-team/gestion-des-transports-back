echo "### Générer image transports-front ###"
docker build -t postgresql-transports-db transports-db/.

echo "### Créer  containeur transports-front ###"
docker run -d --name postgresql-transports-db postgresql-transports-db