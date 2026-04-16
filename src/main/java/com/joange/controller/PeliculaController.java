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
     */
    @GetMapping(value = "/pelicula")
    public String getPeliculas(Model model) {
        List<Pelicula> lasPeliculas = peliculaService.findAllPelicula();
        model.addAttribute("peliculas", lasPeliculas);
        return "peliculas";
    }
    
    /**
     * Ver detalle de una película por ID.
     */
    @GetMapping(value = "/pelicula/{id}")
    public String getPeliculaById(@PathVariable Long id, Model model) {
        Optional<Pelicula> pelicula = peliculaService.findPeliculaById(id);
        if (pelicula.isPresent()) {
            model.addAttribute("pelicula", pelicula.get());
        }
        return "pelicula";
    }
    
    /**
     * Formulario para añadir nueva película.
     * GET /pelicula/add
     * Debe crear una nueva Pelicula vacía y también cargar
     * la lista de directores para el selector del formulario.
     */
    @RequestMapping(value = "/pelicula/add")
    public String addPelicula(Model model) {
        Pelicula p = new Pelicula();
        model.addAttribute("pelicula", p);
        model.addAttribute("directores", directorService.findAllDirector());
        model.addAttribute("nuevo", Optional.of(true));
        return "peliculaForm";
    }
    
    /**
     * Eliminar una película.
     * GET /pelicula/delete/{id}
     */
    @GetMapping(value = "/pelicula/delete/{id}")
    public String deletePelicula(@PathVariable Long id) {
        peliculaService.deletePelicula(id);
        return "redirect:/pelicula";
    }
    
    /**
     * Formulario para modificar película existente.
     * GET /pelicula/update/{id}
     */
    @RequestMapping(value = "/pelicula/update/{id}")
    public String updatePelicula(@PathVariable Long id, Model model) {
        Optional<Pelicula> peliculaOpt = peliculaService.findPeliculaById(id);
        if (peliculaOpt.isPresent()) {
            model.addAttribute("pelicula", peliculaOpt.get());
            model.addAttribute("directores", directorService.findAllDirector());
            model.addAttribute("nuevo", false);
            return "peliculaForm";
        }
        return "redirect:/pelicula";
    }
    
    /**
     * Guardar película (nueva o modificada).
     * POST /pelicula/save
     */
    @PostMapping(value = "/pelicula/save")
    public String savePelicula(@ModelAttribute("pelicula") Pelicula pelicula) {
        peliculaService.savePelicula(pelicula);
        return "redirect:/pelicula";
    }
    
    /**
     * Ver películas de un director específico.
     * GET /pelicula/director/{id}
     */
    @GetMapping(value = "/pelicula/director/{id}")
    public String getPeliculasByDirector(@PathVariable Long id, Model model) {
        List<Pelicula> peliculas = peliculaService.findByDirectorId(id);
        model.addAttribute("peliculas", peliculas);
        return "peliculas";
    }
}
