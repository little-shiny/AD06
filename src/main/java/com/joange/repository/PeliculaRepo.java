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
     * TODO 18: Implementar consulta para buscar películas por id del director.
     * 
     * Pista: Usar @Query con JPQL
     * "SELECT p FROM Pelicula p WHERE p.director.idDirector = ?1"
     */
    // @Query("...")
    // List<Pelicula> findByDirectorId(Long idDirector);
    
    /**
     * TODO 19: Implementar consulta para buscar películas sin director asignado.
     * 
     * Pista: "SELECT p FROM Pelicula p WHERE p.director IS NULL"
     */
    // @Query("...")
    // List<Pelicula> findPeliculasSinDirector();
}
