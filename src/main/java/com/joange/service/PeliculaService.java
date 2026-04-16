package com.joange.service;

import java.util.List;
import java.util.Optional;

import com.joange.model.Pelicula;

/**
 * Interfaz del Servicio de Pelicula.
 * Define los métodos de la lógica de negocio para gestionar películas.
 */
public interface PeliculaService {

    /** Obtener todas las películas */
    public List<Pelicula> findAllPelicula();
    
    /** Buscar película por ID */
    public Optional<Pelicula> findPeliculaById(Long id);
    
    /** Guardar una nueva película */
    public Pelicula savePelicula(Pelicula nuevaPelicula);
    
    /** Eliminar película por ID */
    public String deletePelicula(Long id);
    
    /**
     * TODO 20: Añadir firma del método para buscar películas por director.
     * public List<Pelicula> findByDirectorId(Long idDirector);
     */
    
    /**
     * TODO 21: Añadir firma del método para buscar películas sin director.
     * public List<Pelicula> findPeliculasSinDirector();
     */
}
