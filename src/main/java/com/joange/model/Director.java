package com.joange.model;

import java.io.Serializable;

// TODO 4: Añadir los imports necesarios para las anotaciones JPA
// Pista: javax.persistence.Entity, Id, GeneratedValue, GenerationType, Column, Table

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Entidad Director - Representa un director de cine en la base de datos.
 */
@Entity
@Table(name = "Director")

@Data @AllArgsConstructor @NoArgsConstructor
public class Director implements Serializable {

    
    private static final long serialVersionUID = 1L;

    // Clave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idDirector;

    @Column
    String nombre;
    
    @Column
    int anyoNacimiento;
}
