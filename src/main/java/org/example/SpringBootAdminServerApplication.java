package org.example;

import de.codecentric.boot.admin.server.config.AdminServerHazelcastAutoConfiguration;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;

@EnableAdminServer
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SpringBootAdminServerApplication{

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAdminServerApplication.class, args);
    }
}