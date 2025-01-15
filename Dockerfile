FROM openjdk:21
ARG JAR_FILE=build\libs\retail-restful-service-1.*.jar
COPY ${JAR_FILE} application.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/application.jar"]