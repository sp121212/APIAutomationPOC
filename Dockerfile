#Use a base image with maven and java
FROM maven:3.8.3-openjdk-11

#set the working directory inside the container
WORKDIR /app

#Copy the maven project file into the container
COPY pom.xml .
COPY src ./src

#Switch the directory containing the pom.xml
WORKDIR /app

#Run the maven tests
CMD ["mvn", "test"]