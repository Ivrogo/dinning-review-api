FROM openjdk:17

COPY target/dinning-review-api-0.0.1-SNAPSHOT.jar dinning-review.jar

ENTRYPOINT ["java", "-jar", "/dinning-review.jar"]