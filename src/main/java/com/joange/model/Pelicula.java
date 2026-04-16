package com.joange.model;

import java.io.Serializable;

// TODO 10: Añadir los imports necesarios para las anotaciones JPA
// Pista: Entity, Id, GeneratedValue, GenerationType, Column, Table, ManyToOne, JoinColumn, FetchType


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Entidad Pelicula - Representa una película en la base de datos.
 * Tiene una relación ManyToOne con Director (muchas películas -> un director)
 */
@Entity
@Table(name="Pelicula")

@Data @AllArgsConstructor @NoArgsConstructor
public class Pelicula implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idPelicula;

    @Column
    String titulo;

    @Column
    int anyo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDirector")
    Director director = null;
}
