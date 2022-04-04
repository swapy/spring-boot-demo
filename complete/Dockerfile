# syntax = docker/dockerfile:1.2

## common variables accross stages
ARG depFolder=/opt/src
ARG jarDest=/opt/app


## Step 1: Download required dependencies and cache them with gradle cache
## We are running this separately so that we can cache gradle dependencies.
FROM gradle:7.4.1-jdk17-alpine as dependencies
RUN mkdir -p /opt/src
COPY --chown=gradle:gradle ./* /opt/src

WORKDIR /opt/src
RUN gradle --info dependencies --no-daemon

## Step 2: Build your application with deps from step 1

FROM gradle:7.4.1-jdk17-alpine as buildJar
COPY --from=dependencies /root/.gradle /root/.gradle
COPY --from=dependencies /home/gradle/src /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle clean build --no-daemon --info


## Step 3: Extract jar to create spring boot layers folders
## ref: https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#container-images.dockerfiles

FROM azul/zulu-openjdk-alpine:17.0.0 as extractLayers
RUN --mount=type=cache,target=/var/cache/apt apk update && apk add tzdata
ENV TZ=Asia/Kolkata

COPY --from=buildJar ${depFolder}/build/libs/*.jar ${jarDest}
WORKDIR ${jarDest}
RUN java -Djarmode=layertools -jar application.jar extract


#Step 4: Run spring boot app in layers
FROM azul/zulu-openjdk-alpine:17.0.0 as builder
WORKDIR ${jarDest}
COPY --from=extractLayers application/dependencies/ ./
COPY --from=extractLayers application/spring-boot-loader/ ./
COPY --from=extractLayers application/snapshot-dependencies/ ./
COPY --from=extractLayers application/application/ ./

EXPOSE 8080
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
