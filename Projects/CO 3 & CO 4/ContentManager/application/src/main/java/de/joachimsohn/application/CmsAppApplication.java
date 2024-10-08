package de.joachimsohn.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("de.joachimsohn.application.domain.model")
public class CmsAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmsAppApplication.class, args);
    }

}
