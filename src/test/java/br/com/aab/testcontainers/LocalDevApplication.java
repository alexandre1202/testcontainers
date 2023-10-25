package br.com.aab.testcontainers;

import org.springframework.boot.SpringApplication;

public class LocalDevApplication {
    public static void main(String[] args) {
        SpringApplication.from(TestcontainersApplication::main)
                .with(TestTestcontainersApplication.class)
                .run(args);
    }
}
