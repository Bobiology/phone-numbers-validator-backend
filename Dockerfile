FROM openjdk:11
ADD target/jumia-services-0.0.1-SNAPSHOT.jar jumia-services-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","jumia-services-0.0.1-SNAPSHOT.jar"]