echo off
setlocal enabledelayedexpansion

set CURRENT_DIR=%~dp0
pushd %CURRENT_DIR%
cd %CURRENT_DIR%\..
set BASEDIR=%cd%
popd

echo BASEDIR_START_BAT %BASEDIR%
set NODE_ROOT=%BASEDIR%

rem Pull new changes
git pull

rem Prepare Jar
rem mvn clean
rem mvn package

rem Ensure, that docker-compose stopped
docker-compose -f .indirect/docker-compose.yml stop

rem Start new deployment
docker-compose -f .indirect/docker-compose.yml up --build -d