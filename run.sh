#!/usr/bin/env bash

if [[ -z "${PORT}" ]]; then
  echo "Hay que definir la variable 'export PORT=81'"
  exit 1
else
  echo ""
fi


file="./build/libs/spring-boot-reto-0.0.1-SNAPSHOT.jar"
#./build/libs/* ./spring-boot-reto-0.0.1-SNAPSHOT.jar

if [ -f "$file" ]
then
  echo "$file found."
else
  ./gradlew bootRepackage && cp build/libs/./build/libs/* ./spring-boot-reto-0.0.1-SNAPSHOT.jar src/main/docker/app/./build/libs/* ./spring-boot-reto-0.0.1-SNAPSHOT.jar
fi

cd src/main/docker && docker-compose -p app_${PORT} up --build 

