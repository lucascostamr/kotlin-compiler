FROM eclipse-temurin:21.0.4_7-jre

RUN apt-get upgrade -y\
    && apt-get update -y\
    && apt-get install -y kotlin

WORKDIR /home/user/app

COPY Main.kt .

RUN kotlinc Main.kt -include-runtime -d Main.jar

HEALTHCHECK --interval=30s --timeout=30s --start-period=5s --retries=3 CMD [ "ls", "Main.jar" ]

CMD ["java", "-jar", "Main.jar"]