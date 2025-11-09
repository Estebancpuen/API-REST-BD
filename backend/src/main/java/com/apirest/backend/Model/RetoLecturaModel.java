package com.apirest.backend.Model;

import jakarta.persistence.*;
import java.sql.Date;

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
    
    // Constructor, Getters y Setters...

    public RetoLecturaModel() {
    }

    // --- Getters y Setters ---

    public Integer getIdReto() {
        return idReto;
    }

    public void setIdReto(Integer idReto) {
        this.idReto = idReto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}