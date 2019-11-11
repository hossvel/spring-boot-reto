FROM openjdk:8-jdk-alpine

EXPOSE 8081

ADD spring-boot-reto.jar /spring-boot-reto.jar

ADD wait-for-it.sh /wait-for-it.sh
ADD start.sh /start.sh
RUN sh -c 'chmod +x /*.sh'

#ENTRYPOINT ["java", "-jar", "/app.jar"]
ENTRYPOINT ["/wait-for-it.sh","postgres:5432", "--", "/start.sh"]