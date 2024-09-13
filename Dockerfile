FROM eclipse-temurin:21.0.4_7-jdk-alpine
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests
EXPOSE 3000
CMD [ "java", "-jar", "target/api-milhas-0.0.1-SNAPSHOT.jar" ]