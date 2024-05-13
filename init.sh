sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie

curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.38.0/install.sh | bash
. ~/.nvm/nvm.sh
nvm install 14.19.0 && nvm use 14.19.0
export NODE_OPTIONS=--openssl-legacy-provider

cd infra
docker-compose up
