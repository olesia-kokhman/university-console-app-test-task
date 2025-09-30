package com.olesia.university;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UniversityConsoleAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(UniversityConsoleAppApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ConsoleUI console) {
        return args -> console.start();
    }

}
