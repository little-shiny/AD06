package com.joange.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador principal de la aplicación.
 * Gestiona la página de inicio.
 */
@Controller
public class AppController {

    /**
     * Página de inicio de la aplicación.
     * Devuelve la vista "index" (templates/index.html)
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
