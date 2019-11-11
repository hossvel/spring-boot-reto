#!/usr/bin/env bash

if [[ -z "${PORT}" ]]; then
  echo "Hay que definir la variable 'export PORT=81'"
  exit 1
else
  echo ""
fi


file="../build/libs/spring-boot-reto.jar"
if [ -f "$file" ]
then
  echo "$file found."
else
  ./gradlew bootJar && cp build/libs/spring-boot-reto.jar src/main/docker/app/spring-boot-reto.jar
fi

cd src/main/docker && docker-compose -p app_${PORT} up --build 

