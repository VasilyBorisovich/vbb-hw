# The all additional files are in .indirect folder

# pipefail will be fail pipe if command return the error
SHELL=/bin/bash -o pipefail

ifeq ($(CI_JOB_ID),)
    CI_JOB_ID := local
endif

export COMPOSE_PROJECT_NAME = $(CI_JOB_ID)-vbb

# stopping and remove container, network, volumes etc
docker-down:
    docker-compose -f .indirect/docker-compose.yml down

docker-up: docker-down
    # get last image from docker-registry
    docker-compose -f .indirect/docker-compose.yml pull
    # start env
    # force-recreate - recreate container
    # renew-anon-volumes - dont use vloume from prev container
    docker-compose -f .indirect/docker-compose.yml up --force-recreate --renew-anon-volumes -d
    docker ps

# collect all logs
docker-logs:
    mkdir -p ./logs
    docker logs $${COMPOSE_PROJECT_NAME}_web_1       >& logs/vbb-web.log       || true

# clean runner
    @echo Stopping all vbb-containers
    docker kill $$(docker ps --filter=name=vbb -q) || true
    @echo Clean docker container
    docker rm -f $$(docker ps -a -f --filter=name=testrail status=exited -q) || true
    @echo Clean dangling images
    docker rmi -f $$(docker images -f "dangling=true" -q) || true
    #@echo Clean vbb images
    #docker rmi -f $$(docker images --filter=reference='registry.gitlab.com/touchbit/image/testrail/*' -q) || true
    @echo The clean all unused volume
    docker volume rm -f $$(docker volume ls -q) || true
    @echo Clean all vbb network
    docker network rm $(docker network ls --filter=name=vbb -q) || true
    docker ps