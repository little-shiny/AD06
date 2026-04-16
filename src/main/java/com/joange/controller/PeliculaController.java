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
import com.joange.model.Pelicula;
import com.joange.service.DirectorService;
import com.joange.service.PeliculaService;

/**
 * Controlador MVC para gestionar Películas.
 */
@Controller
public class PeliculaController {
    
    @Autowired
    private PeliculaService peliculaService;
    
    @Autowired
    private DirectorService directorService;

    /**
     * Listar todas las películas.
     * GET /pelicula
     * 
     * TODO 26: Implementar este método.
     * Debe obtener todas las películas y añadirlas al modelo.
     */
    @GetMapping(value = "/pelicula")
    public String getPeliculas(Model model) {
        // TODO: Obtener películas y añadir al modelo
        // List<Pelicula> lasPeliculas = peliculaService.findAllPelicula();
        // model.addAttribute("peliculas", lasPeliculas);
        return "peliculas";
    }
    
    /**
     * Ver detalle de una película por ID.
     * GET /pelicula/{id}
     * 
     * TODO 27: Implementar este método.
     */
    @GetMapping(value = "/pelicula/{id}")
    public String getPeliculaById(@PathVariable Long id, Model model) {
        // TODO: Buscar película por ID y añadir al modelo
        return "pelicula";
    }
    
    /**
     * Formulario para añadir nueva película.
     * GET /pelicula/add
     * 
     * TODO 28: Implementar este método.
     * Debe crear una nueva Pelicula vacía y también cargar
     * la lista de directores para el selector del formulario.
     */
    @RequestMapping(value = "/pelicula/add")
    public String addPelicula(Model model) {
        // TODO: Crear nueva película y cargar lista de directores
        // Pelicula p = new Pelicula();
        // model.addAttribute("pelicula", p);
        // model.addAttribute("directores", directorService.findAllDirector());
        // model.addAttribute("nuevo", true);
        return "peliculaForm";
    }
    
    /**
     * Eliminar una película.
     * GET /pelicula/delete/{id}
     * 
     * TODO 29: Implementar este método.
     */
    @GetMapping(value = "/pelicula/delete/{id}")
    public String deletePelicula(@PathVariable Long id) {
        // TODO: Eliminar película
        // peliculaService.deletePelicula(id);
        return "redirect:/pelicula";
    }
    
    /**
     * Formulario para modificar película existente.
     * GET /pelicula/update/{id}
     * 
     * TODO 30: Implementar este método.
     */
    @RequestMapping(value = "/pelicula/update/{id}")
    public String updatePelicula(@PathVariable Long id, Model model) {
        // TODO: Buscar película y cargar formulario de edición
        return "redirect:/pelicula";
    }
    
    /**
     * Guardar película (nueva o modificada).
     * POST /pelicula/save
     * 
     * TODO 31: Implementar este método.
     */
    @PostMapping(value = "/pelicula/save")
    public String savePelicula(@ModelAttribute("pelicula") Pelicula pelicula) {
        // TODO: Guardar película
        // peliculaService.savePelicula(pelicula);
        return "redirect:/pelicula";
    }
    
    /**
     * Ver películas de un director específico.
     * GET /pelicula/director/{id}
     * 
     * TODO 32: Implementar este método (OPCIONAL - Avanzado).
     * Debe mostrar solo las películas de un director concreto.
     */
    @GetMapping(value = "/pelicula/director/{id}")
    public String getPeliculasByDirector(@PathVariable Long id, Model model) {
        // TODO: Filtrar películas por director
        return "peliculas";
    }
}
