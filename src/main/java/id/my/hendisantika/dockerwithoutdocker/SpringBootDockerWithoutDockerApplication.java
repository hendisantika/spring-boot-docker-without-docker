package id.my.hendisantika.dockerwithoutdocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@SpringBootApplication
public class SpringBootDockerWithoutDockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDockerWithoutDockerApplication.class, args);
    }

    @GetMapping("/")
    public String index() {
        return "Spring Boot with Jib Demo! " + LocalDateTime.now();
    }

}
