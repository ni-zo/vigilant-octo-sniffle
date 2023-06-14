
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template


# Use the openjdk:17-jdk-alpine image as the base image
FROM openjdk:17-jdk-alpine AS builder

# Set the working directory to
WORKDIR /usr/src/app

# Copy the pom.xml file and the mvnw wrapper script
COPY pom.xml .mvn mvnw ./

# Copy all
COPY   . .

# Download the dependencies and build the application without test
RUN ./mvnw dependency:go-offline -B && \
    ./mvnw package -DskipTests




FROM joengenduvel/jre17:alpine3.14 
WORKDIR  /usr/src/app

#create non-root without password but home dir
#RUN adduser -D DIR appuser
#USER appuser

#image listen to port
expose 8080 

RUN mkdir /app
# Copy the built application from the builder image
COPY --from=builder /usr/src/app/target/beauty-0.0.1-SNAPSHOT.jar /usr/src/app

# Run the application
cmd ["java", "-jar", "beauty-0.0.1-SNAPSHOT.jar"]
