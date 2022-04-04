# syntax = docker/dockerfile:1.2

FROM gradle:7.4.1-jdk17-alpine as builder
RUN apk update && apk add tzdata
ENV TZ=Asia/Kolkata
RUN mkdir src
COPY --chown=gradle:gradle ../../ /home/gradle/src
WORKDIR /home/gradle/src
RUN ls
# RUN gradle clean build --no-daemon

# COPY ../build/libs/* /opt/application.jar
# RUN java -Djarmode=layertools -jar /opt/application.jar extract



# FROM azul/zulu-openjdk-alpine:17.0.0 as runMyJar
# # add timezone
# RUN apk update && apk add tzdata
# ENV TZ=Asia/Kolkata

# WORKDIR /opt
# COPY --from=builder ./dependencies/ ./
# COPY --from=builder ./spring-boot-loader/ ./
# COPY --from=builder ./snapshot-dependencies/ ./
# COPY --from=builder ./application/ ./

# EXPOSE 8080
# ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]


# RUN mkdir -p /tools
# #COPY health-check.sh /tools
# #HEALTHCHECK --interval=2s CMD /tools/health-check.sh

# RUN mkdir -p /app
# COPY accessing-data-mysql-0.0.1-SNAPSHOT.jar /app
# CMD ["java", "-jar", "/app/accessing-data-mysql-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080
