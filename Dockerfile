FROM openjdk:15-jdk-alpine3.11

RUN mkdir /app

WORKDIR /app

COPY target/sparrowShop-0.0.1-SNAPSHOT.jar /app

EXPOSE 8080

CMD [ "java", "-jar", "sparrowShop-0.0.1-SNAPSHOT.jar" ]
