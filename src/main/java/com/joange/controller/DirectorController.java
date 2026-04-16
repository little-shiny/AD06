package com.joange.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joange.model.Director;
import com.joange.service.DirectorService;

/**
 * Controlador MVC para gestionar Directores.
 * 
 * La anotación @Controller indica que esta clase maneja peticiones web
 * y devuelve vistas (plantillas Thymeleaf).
 */
@Controller
public class DirectorController {
    
    @Autowired
    private DirectorService directorService;

    /**
     * Listar todos los directores.
     * GET /director
     */
    @GetMapping(value = "/director")
    public String getDirector(Model model) {
        List<Director> losDirectores = directorService.findAllDirector();
        model.addAttribute("directores", losDirectores);
        return "directores";
    }
    
    /**
     * Ver detalle de un director por ID.
     * GET /director/{id}
     */
    @GetMapping(value = "/director/{id}")
    public String getDirectorById(@PathVariable Long id, Model model) {
        Optional<Director> elDirector = directorService.findDirectorById(id);
        if (elDirector.isPresent()) {
            model.addAttribute("director", elDirector.get());
            model.addAttribute("vacio", false);
        } else {
            model.addAttribute("msg", "Sin directores con id " + id);
            model.addAttribute("vacio", true);
        }
        return "director";
    }
    
    /**
     * Formulario para añadir nuevo director.
     * GET /director/add
     * 
     * TODO 33: Completar este método.
     * Debe crear un nuevo objeto Director vacío y añadirlo al modelo.
     * También debe añadir el atributo "nuevo" = true.
     */
    @RequestMapping(value = "/director/add")
    public String addDirector(Model model) {
        // TODO: Crear nuevo Director y añadir al modelo
        // Director d = new Director();
        // model.addAttribute("director", d);
        // model.addAttribute("nuevo", true);
        return "directorForm";
    }
    
    /**
     * Eliminar un director.
     * GET /director/delete/{id}
     */
    @GetMapping(value = "/director/delete/{id}")
    public String deleteDirector(@PathVariable Long id) {
        String respuesta = directorService.deleteDirector(id);
        System.out.println(respuesta);
        return "redirect:/director";
    }
    
    /**
     * Formulario para modificar director existente.
     * GET /director/update/{id}
     * 
     * TODO 34: Completar este método.
     * Debe buscar el director por ID y si existe, añadirlo al modelo
     * con el atributo "nuevo" = false.
     */
    @RequestMapping(value = "/director/update/{id}")
    public String updateDirector(@PathVariable Long id, Model model) {
        // TODO: Buscar director y añadir al modelo
        // Optional<Director> directorOpt = directorService.findDirectorById(id);
        // if (directorOpt.isPresent()) {
        //     model.addAttribute("director", directorOpt.get());
        //     model.addAttribute("nuevo", false);
        //     return "directorForm";
        // }
        return "redirect:/director";
    }
    
    /**
     * Guardar director (nuevo o modificado).
     * POST /director/save
     * 
     * La anotación @ModelAttribute vincula los datos del formulario
     * con el objeto Director.
     */
    @PostMapping(value = "/director/save")
    public String saveDirector(@ModelAttribute("director") Director director) {
        directorService.saveDirector(director);
        return "redirect:/director";
    }
}
