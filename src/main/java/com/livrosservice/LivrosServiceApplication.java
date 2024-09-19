package com.livrosservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LivrosServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LivrosServiceApplication.class, args);
        System.out.println("Livros Service Is Running!");
    }

}
