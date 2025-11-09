package com.apirest.backend.Model;

import jakarta.persistence.*;
import java.sql.Date;
import java.sql.Timestamp; // Para DATETIME

@Entity
@Table(name = "Resena")
public class ResenaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idResena;

    // Clave Foránea 1: Relación con Usuario
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", nullable = false)
    private UsuarioModel usuario;
    
    // Clave Foránea 2: Relación con Libro
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLibro", nullable = false)
    private LibroModel libro;

    @Column(nullable = false)
    private Date fecha;

    @Column(columnDefinition = "TEXT")
    private String opinion;

    // La validación CHECK (calificacion BETWEEN 1 AND 5) debe manejarse a nivel de la aplicación/servicio, aunque JPA soporta @Column(columnDefinition = "INT CHECK (calificacion BETWEEN 1 AND 5)")
    @Column(nullable = false)
    private Integer calificacion; 

    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt; // Se manejará automáticamente por la DB (DEFAULT CURRENT_TIMESTAMP)
    
    // Constructor, Getters y Setters...

    public ResenaModel() {
    }

    // --- Getters y Setters ---

    public Integer getIdResena() {
        return idResena;
    }

    public void setIdResena(Integer idResena) {
        this.idResena = idResena;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public LibroModel getLibro() {
        return libro;
    }

    public void setLibro(LibroModel libro) {
        this.libro = libro;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}