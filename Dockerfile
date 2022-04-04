FROM openjdk:8
EXPOSE 8080
COPY ./target/demotestingrestendpoint-0.0.1-SNAPSHOT.jar  /usr/local/bin/test.jar
CMD ["java","-jar","test.jar]
