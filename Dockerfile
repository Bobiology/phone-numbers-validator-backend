FROM openjdk:11
ADD target/phone-numbers-validator-0.0.1-SNAPSHOT.jar phone-numbers-validator-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","phone-numbers-validator-0.0.1-SNAPSHOT.jar"]