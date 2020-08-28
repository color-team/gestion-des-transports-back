

echo "### Générer image transports-front ###"
docker build -t postgresql-transports-front transports-front/.

echo "### Créer  containeur transports-front ###"
docker run -d --name postgresql-transports-front postgresql-transports-front