package com.joange.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.joange.model.Pelicula;

/**
 * Repositorio de Pelicula - Interfaz que extiende JpaRepository.
 * Ya está correctamente definido como JpaRepository<Pelicula, Long>
 */
public interface PeliculaRepo extends JpaRepository<Pelicula, Long> {

    /**
     * Consulta que busca peliculas por la id del director
     */
     @Query("SELECT p FROM Pelicula p WHERE p.director.idDirector = ?1")
     List<Pelicula> findByDirectorId(Long idDirector);
    
    /**
     * Consulta que sirve para buscar películas sin director asignado.
     */
    @Query("SELECT p FROM Pelicula p WHERE p.director IS NULL")
    List<Pelicula> findPeliculasSinDirector();
}
