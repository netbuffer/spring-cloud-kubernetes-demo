FROM openjdk:8-slim-buster
ADD target/user-service-invoker.jar /user-service-invoker.jar
ENTRYPOINT java ${JAVA_OPTS} -jar /user-service-invoker.jar