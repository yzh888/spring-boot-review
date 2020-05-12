package com.soft1851.springboot.configuration;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringBootConfigurationApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringBootConfigApplication.class, args);
        new SpringApplicationBuilder(SpringBootConfigurationApplication.class)
                .bannerMode(Banner.Mode.CONSOLE).run(args);
    }
}
