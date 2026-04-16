package com.joange.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.joange.model.Director;

/**
 * Repositorio de Director - Interfaz que extiende JpaRepository.
 * Spring Data JPA implementa automáticamente los métodos CRUD básicos.
 * 
 * JpaRepository<Director, Long>:
 * - Director: la entidad que gestiona
 * - Long: el tipo de la clave primaria
 */
public interface DirectorRepo extends JpaRepository<Director, Long> {

    /**
     * Consulta personalizada: Buscar directores nacidos antes de 1970.
     * La anotación @Query permite escribir consultas JPQL personalizadas.
     */
    @Query("SELECT d FROM Director d WHERE d.anyoNacimiento < 1970")
    List<Director> findOldDirector();
    
    /**
     * Consulta que busca directores por año de nacimiento
     */
    @Query("SELECT d FROM Director d WHERE d.anyoNacimiento = ?1")
    List<Director> findDirectorByYear(Integer year);
}
