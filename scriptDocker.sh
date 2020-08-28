echo "### Générer image transports-db ###"
docker build -t postgresql-transports-db transports-db/.

echo "### Créer  containeur transports-db ###"
docker run -d --name postgresql-transports-db postgresql-transports-db