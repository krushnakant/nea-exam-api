package com.nea.eaxmpaper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan("com.nea.eaxmpaper.*")
//@EntityScan("com.nea.eaxmpaper.*")
//@EnableJpaRepositories("com.nea.eaxmpaper.*")
public class EaxmpaperApplication {

    public static void main(String[] args) {
        SpringApplication.run(EaxmpaperApplication.class, args);
    }

}
