FROM openjdk:8-slim-buster
ADD target/user-service-provider.jar /user-service-provider.jar
ENTRYPOINT java ${JAVA_OPTS} -jar /user-service-provider.jar