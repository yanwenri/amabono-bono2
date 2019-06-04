FROM openjdk:8-jre-alpine
COPY target/*.jar bono.jar
CMD ["java","-jar","/bono.jar"]
