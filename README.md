# 3 Ways to Build Docker Images for Spring Boot Applications

[![Java CI with Maven](https://github.com/hendisantika/spring-boot-docker-without-docker/actions/workflows/maven.yml/badge.svg)](https://github.com/hendisantika/spring-boot-docker-without-docker/actions/workflows/maven.yml)

I have three mechanisms in the same pom file which are put under different maven profiles.

## Tech Stack

- Java 25
- Spring Boot 4.1.1
- Maven 3.10 (via the Maven Wrapper `./mvnw`)
- Base images: `amazoncorretto:25` / `amazoncorretto:25-alpine3.22` (JIB & Fabric8), Paketo buildpacks with
  `BP_JVM_VERSION=25` (Spring Boot plugin)

## Prerequisites

- JDK 25
- Docker (running locally) for building images

## Build & Run Locally

```shell
./mvnw clean verify
./mvnw spring-boot:run
```

## Building Docker Images

- Building Image with Spring Boot Build Plugin (produces `docker.io/hendisantika/docker-without-docker:0.0.2`):

    ```shell
    ./mvnw clean verify spring-boot:build-image
    ```

- Building Image with Fabric8 (produces `spring-boot-docker-without-docker:0.0.2`):

    ```shell
    ./mvnw clean verify -DskipTests -Pbuild-with-fabric-8
    ```

- Building Image with JIB (produces `jib-build-spring-boot-docker-without-docker:0.0.2`):

    ```shell
    ./mvnw clean verify -DskipTests -Pbuild-with-jib
    ```

- Push Image to Docker Hub:

    ```shell
    ./mvnw clean verify -DskipTests -Pdockerhub
    ```

## Start the container

```shell
docker run --name spring-boot-docker-without-docker -p 8080:8080 spring-boot-docker-without-docker:0.0.2
```

## APIs for testing

> 1st: http://localhost:8080/api/v1/customers

<br/>

> 2nd: http://localhost:8080/api/v1/customers/male

## CI/CD

The [GitHub Actions workflow](.github/workflows/maven.yml) builds with Temurin JDK 25, builds images with all three
mechanisms, pushes a multi-arch (`linux/amd64`, `linux/arm64`) image to Docker Hub tagged with the run number, then
deploys it to the development server. It needs these repository secrets: `DOCKERHUB_USERNAME`, `DOCKERHUB_TOKEN`
(a Docker Hub personal access token with Read & Write scope) and the SSH secrets used by the deploy job.
