#!/bin/bash

cd `dirname "$0"`/..
NODE_ROOT=`pwd`
export NODE_ROOT=$NODE_ROOT
echo "PWD = $NODE_ROOT"

# Pull new changes
git pull

# Prepare Jar
#mvn clean
#mvn package

# Ensure, that docker-compose stopped
docker-compose -f .indirect/docker-compose.yml stop

# Add environment variables
export BOT_NAME=$1
export BOT_TOKEN=$2

# Start new deployment
docker-compose -f .indirect/docker-compose.yml up --build -d