FROM openjdk:17

# 设置工作目录
WORKDIR /app

COPY build/libs/infinitibyte-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]