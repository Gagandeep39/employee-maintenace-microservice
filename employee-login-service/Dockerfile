FROM openjdk:8-jdk-alpine
ADD target/employee-login-service-0.0.1-SNAPSHOT.jar employee-login-service.jar 
EXPOSE 9100
# Here we are exclicitly specifying docer the url 
# Container does not run on localhost which cause eureka server to not comminicate with other
ENTRYPOINT [ "java", "-jar", "employee-login-service.jar", "--eureka.instance.hostname=192.168.99.100" ]

# Steps to run
# 1. Build jar file
# mvn package
# 3. Create a container from image
# docker build -t employee-login-service:tag_name .
# 4. Run th container
# docker run -p 9100:9100 -p 9050:9050 employe-login-service
# Here 9050 is exposed as it has h2 database running
# If there is eror then useo image instead of name
