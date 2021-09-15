FROM openjdk:8-jdk-alpine
MAINTAINER Maikon Canuto
COPY target/agendamento-maplink-0.0.1-SNAPSHOT.jar agendamento.jar
ENTRYPOINT ["java","-jar","/agendamento.jar"]