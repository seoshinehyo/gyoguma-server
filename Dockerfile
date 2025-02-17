FROM openjdk:21-jdk

RUN ln -snf /usr/share/zoneinfo/Asia/Seoul /etc/localtime

COPY ./build/libs/*.jar app.jar

#ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app.jar"]

#ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "app.jar"]

ENTRYPOINT ["java", "-jar", "app.jar"]
