#defining a base docker image

FROM openjdk:17
LABEL maintainers="userTasksSystem.net"
ADD target/user-tasks-system.jar usertaskssystem-docker.jar
ENTRYPOINT ["java","-jar","usertaskssystem-docker.jar"]
