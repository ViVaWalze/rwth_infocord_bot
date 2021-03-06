FROM gradle:6.8.3-jdk11 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle shadowJar --no-daemon

FROM openjdk:11-jre-slim

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/bot.jar

ENTRYPOINT ["java","-jar","/app/bot.jar"]
