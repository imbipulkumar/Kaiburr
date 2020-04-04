FROM openjdk:8-alpine
EXPOSE 8080
ADD target/swagger-spring.jar swagger-spring.jar
ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://mongodb:27017/servers", "-jar", "/swagger-spring.jar"]
