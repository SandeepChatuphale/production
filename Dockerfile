FROM openjdk:8
EXPOSE 8080
ADD target/demotestingrestendpoint-0.0.1-SNAPSHOT.jar  demotestingrestendpoint-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","/demotestingrestendpoint-0.0.1-SNAPSHOT.jar]
