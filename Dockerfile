FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD ./target/movieCatalog-0.0.1-SNAPSHOT.jar moviecatalog.jar
ENTRYPOINT ["java","-jar","/moviecatalog.jar"]