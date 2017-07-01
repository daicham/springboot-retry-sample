package com.daicham.springbootretrysample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

/**
 * @author daicham
 */
@SpringBootApplication
@EnableRetry
public class App {
    public static void main(String... args) {
        SpringApplication.run(App.class, args);
    }
}

