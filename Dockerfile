ENTRYPOINT ["top", "-b"]
# Use official Maven with JDK image
FROM maven:3.9.6-eclipse-temurin-21

# Set work directory
WORKDIR /usr/src/app

# Copy project files into container
COPY . .

# Download dependencies
RUN mvn dependency:resolve

# Default command to run tests (can be overridden)
CMD ["mvn", "clean", "test"]
