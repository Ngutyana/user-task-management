FROM openjdk:17
ADD target/user-tasks-system.jar user-tasks-system.jar
ENTRYPOINT ["java","-jar","/user-tasks-system.jar"]
