FROM maven:3.9.2-amazoncorretto-17
WORKDIR /app
COPY . /app/
RUN mvn clean package -DskipTests
EXPOSE 8080
CMD ["mvn", "spring-boot:run"]