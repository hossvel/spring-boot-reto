FROM openjdk:8u151-slim

EXPOSE 8080

ADD app.jar /app.jar
ADD wait-for-it.sh /wait-for-it.sh
ADD start.sh /start.sh
RUN sh -c 'chmod +x /*.sh'

#ENTRYPOINT ["java", "-jar", "/app.jar"]
ENTRYPOINT ["/wait-for-it.sh","postgres:5432", "--", "/start.sh"]