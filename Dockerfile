
# Base Image and name stage as "builder"
FROM maven:3-openjdk-17 AS builder
# Create App Directory inside our container
WORKDIR /juan/app/src/
# Copy files
COPY src ./
COPY pom.xml ../
RUN mvn -f /juan/app/pom.xml clean package

#### 2nd Stage ####

FROM openjdk:17-alpine
WORKDIR /juan/lib/
# Copy the Jar from the first Stage (builder) to the 2nd stage working directory
COPY --from=builder /juan/app/target/asp-solutions-0.0.1-SNAPSHOT.jar ./app.jar
# Expose the port to the inner container communication network
EXPOSE 3100
# Run the Java Application
ENTRYPOINT [ "java","-jar","/juan/lib/app.jar", "--environment=Development"]