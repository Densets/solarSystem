package com.system.solar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication

@EnableScheduling
@EnableAutoConfiguration
public class MainSpringBoot {

    public static void main(final String[] args) {
	SpringApplication.run(MainSpringBoot.class, args);
    }
}
