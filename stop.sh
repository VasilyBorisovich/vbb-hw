#!/bin/bash

# Ensure, that docker-compose stopped
docker-compose -f .indirect/docker-compose.yml stop

# Ensure, that the old application won't be deployed again.
mvn clean