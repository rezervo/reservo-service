FROM maven:3 as BUILD_IMAGE
ENV APP_HOME=/root/dev/reservo-service/
RUN mkdir -p $APP_HOME/src/main/java
WORKDIR $APP_HOME
COPY . .
RUN mvn package -Dmaven.test.skip=true -f pom.xml

FROM openjdk:17
WORKDIR /root/
COPY --from=BUILD_IMAGE /root/dev/reservo-service/reservo-service/target/reservo-service*.jar .
CMD java, -jar, reservo-service*.jar