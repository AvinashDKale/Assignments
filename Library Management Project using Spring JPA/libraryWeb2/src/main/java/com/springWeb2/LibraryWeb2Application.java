package com.springWeb2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class LibraryWeb2Application {
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(LibraryWeb2Application.class, args);
    }
    
}
