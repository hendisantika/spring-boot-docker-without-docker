# 3 Ways to Build Docker Images for Spring Boot Applications

I have three mechanisms in the same pom file which are put under different maven profiles.

- Building Image with Spring Boot Build Plugin:

    ```shell
    mvn clean verify spring-boot:build-image
    ```

- Building Image with Fabric8:

    ```shell
    mvn clean verify -DskipTests -Pbuild-with-fabric-8
    ```


- Building Image with JIB:

    ```shell
    mvn clean verify -DskipTests -Pbuild-with-jib
    ```
- Push Image to Docker Hub:

    ```shell
    mvn clean verify -DskipTests -Pdockerhub
    ```
- Start the container
  ```shell
  docker run --name spring-boot-docker-without-docker -p 8080:8080 spring-boot-docker-without-docker:0.0.1
  ```
- APIs for testing :

> 1st: https://localhost:8080/api/v1/customers

<br/>

> 2nd: https://localhost:8080/api/v1/customers/maleCustomers
