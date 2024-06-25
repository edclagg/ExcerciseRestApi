FROM eclipse-temurin:17.0.11_9-jdk
EXPOSE 8080
WORKDIR /root
COPY ./pom.xml /root
COPY ./.mvn /root/.mvn
COPY ./mvnw /root
RUN ./mvnw dependency:go-offline
COPY ./src /root/src
RUN ./mvnw clean install -DskipTest
ENTRYPOINT ["java","-jar","/root/target/ExcerciseApiRest-0.0.1-SNAPSHOT.jar"]
