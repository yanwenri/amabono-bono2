FROM openjdk:8-jre-alpine
COPY Amabono-bono/target/*.jar bono.jar
CMD ["java","-jar","/bono.jar"]
