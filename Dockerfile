FROM openjdk:11
COPY target/springboot-ec-mall-1.0.0.jar demo.jar
ENTRYPOINT ["java","-jar","demo.jar"]
