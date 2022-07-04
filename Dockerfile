FROM adoptopenjdk/openjdk11

ADD build/libs/spring-fun-0.0.1.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]