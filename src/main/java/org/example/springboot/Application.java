package org.example.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // using SpringApplication runs internal WAS (Web Application Server)
        // so we don't need to run Tomcat to run the application
        // this is important & convenient because Spring Boot can be distributed in the same environment anywhere
        SpringApplication.run(Application.class, args);
    }
}
