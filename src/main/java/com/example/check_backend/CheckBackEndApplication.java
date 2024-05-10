package com.example.check_backend;

import com.example.check_backend.global.security.jwt.JwtProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(JwtProperties.class)
@SpringBootApplication
public class CheckBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(CheckBackEndApplication.class, args);
    }

}
