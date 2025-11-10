package com.apirest.backend.Model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RetoLectura")
public class RetoLecturaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReto;

    @Column(length = 100, nullable = false)
    private String titulo;

    @Column(length = 300)
    private String descripcion;

    private Date fechaInicio;

    private Date fechaFin;
    
    // No necesitamos constructores, getters ni setters gracias a Lombok
}