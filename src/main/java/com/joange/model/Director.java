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
 *
 * TODO 5: Añadir la anotación @Entity para marcar esta clase como entidad JPA
 * TODO 6: Añadir la anotación @Table(name="Director") para mapear a la tabla
 */
@Entity
@Table(name = "Director")

@Data @AllArgsConstructor @NoArgsConstructor
public class Director implements Serializable {

    
    private static final long serialVersionUID = 1L;
    
    /**
     * TODO 7: Añadir las anotaciones para el identificador:
     * - @Id para marcar como clave primaria
     * - @GeneratedValue(strategy = GenerationType.IDENTITY) para autoincremento
     */
    Long idDirector;
    
    /**
     * TODO 8: Añadir la anotación @Column para mapear este atributo
     */
    String nombre;
    
    /**
     * TODO 9: Añadir la anotación @Column para mapear este atributo
     */
    int anyoNacimiento;
}
