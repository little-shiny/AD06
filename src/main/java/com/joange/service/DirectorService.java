package com.joange.service;

import java.util.List;
import java.util.Optional;

import com.joange.model.Director;

/**
 * Interfaz del Servicio de Director.
 * Define los métodos de la lógica de negocio para gestionar directores.
 * La implementación estará en DirectorServiceImpl.
 */
public interface DirectorService {

    /** Obtener todos los directores */
    public List<Director> findAllDirector();
    
    /** Buscar director por ID */
    public Optional<Director> findDirectorById(Long id);
    
    /** Guardar un nuevo director */
    public Director saveDirector(Director nuevoDirector);
    
    /** Eliminar director por ID */
    public String deleteDirector(Long id);
    
    /** Actualizar director existente */
    public String updateDirector(Director nuevoDirector);
    
    /** Buscar directores nacidos antes de 1970 */
    public List<Director> findOldDirector();
}
