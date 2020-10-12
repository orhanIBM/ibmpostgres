FROM openjdk:11.0.8-slim

COPY target/*.jar /app.jar

RUN mkdir .postgresql

COPY root.crt ./.postgresql

ENTRYPOINT ["java", "-jar", "app.jar" ]
