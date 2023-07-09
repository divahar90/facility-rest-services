FROM maven:3.8.3-openjdk-17-slim AS build
WORKDIR /home/app

COPY ./pom.xml /home/app/pom.xml
COPY ./src/main/java/com/condo/management/facilityrestservices/FacilityRestServicesApplication.java	/home/app/src/main/java/com/condo/management/facilityrestservices/FacilityRestServicesApplication.java

RUN mvn -f /home/app/pom.xml clean package

COPY . /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:17.0-slim
EXPOSE 8080
COPY --from=build /home/app/target/*.jar app.jar
ENTRYPOINT [ "sh", "-c", "java -jar /app.jar", "--spring.profiles.active=docker" ]