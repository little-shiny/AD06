package com.joange.model;

import java.io.Serializable;

// TODO 10: Añadir los imports necesarios para las anotaciones JPA
// Pista: Entity, Id, GeneratedValue, GenerationType, Column, Table, ManyToOne, JoinColumn, FetchType


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad Pelicula - Representa una película en la base de datos.
 * Tiene una relación ManyToOne con Director (muchas películas -> un director)
 * 
 * TODO 11: Añadir la anotación @Entity
 * TODO 12: Añadir la anotación @Table(name="Pelicula")
 */

@Data @AllArgsConstructor @NoArgsConstructor
public class Pelicula implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * TODO 13: Añadir las anotaciones @Id y @GeneratedValue
     */
    Long idPelicula;
    
    /**
     * TODO 14: Añadir la anotación @Column
     */
    String titulo;
    
    /**
     * TODO 15: Añadir la anotación @Column
     */
    int anyo;
    
    /**
     * Relación ManyToOne: Muchas películas pueden tener el mismo director.
     * 
     * TODO 16: Añadir las anotaciones para la relación:
     * - @ManyToOne(fetch = FetchType.EAGER) para cargar el director junto con la película
     * - @JoinColumn(name = "idDirector") para indicar la columna de la FK
     */
    Director director = null;
}
