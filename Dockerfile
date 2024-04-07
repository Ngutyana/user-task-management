#defining a base docker image

FROM openjdk:17
LABEL maintainer="Unathi Ngutyana <unathingutyana@gmail.com>"
ADD target/user-tasks-system.jar user-tasks-system.jar
ENTRYPOINT ["java","-jar","/user-tasks-system.jar"]
