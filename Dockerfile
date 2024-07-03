## Используйте официальный образ Java 17
#FROM openjdk:17-jdk-slim
#
## Установите рабочий каталог в контейнере
#WORKDIR /app
#
## Скопируйте JAR файл в рабочий каталог
#COPY target/Booking-0.0.1-SNAPSHOT.jar /app/Booking-0.0.1-SNAPSHOT.jar
#
## Задайте команду для запуска JAR файла
#ENTRYPOINT ["java", "-jar", "Booking-0.0.1-SNAPSHOT.jar"]




# Используем официальный образ OpenJDK 17 в качестве базового образа
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию в контейнере
WORKDIR /app

# Копируем JAR файл вашего приложения в контейнер
COPY target/Booking-0.0.1-SNAPSHOT.jar /app/Booking-0.0.1-SNAPSHOT.jar

# Указываем команду для запуска вашего приложения
ENTRYPOINT ["java", "-jar", "Booking-0.0.1-SNAPSHOT.jar"]
