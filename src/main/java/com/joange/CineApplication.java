package com.joange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación Spring Boot.
 * Esta clase arranca el servidor embebido Tomcat y configura Spring.
 */
@SpringBootApplication
public class CineApplication {

    public static void main(String[] args) {
        SpringApplication.run(CineApplication.class, args);
        System.out.println("===========================================");
        System.out.println("  Aplicación Cine iniciada correctamente");
        System.out.println("  Accede a: http://localhost:8080");
        System.out.println("===========================================");
    }
}
