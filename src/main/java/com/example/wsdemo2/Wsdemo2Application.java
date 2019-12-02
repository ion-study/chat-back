package com.example.wsdemo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Wsdemo2Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Wsdemo2Application.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Wsdemo2Application.class);
    }

}
