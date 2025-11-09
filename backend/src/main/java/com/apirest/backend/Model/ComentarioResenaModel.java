package com.apirest.backend.Model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ComentarioResena")
public class ComentarioResenaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComentario;

    // Clave Foránea 1: Relación con Usuario
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", nullable = false)
    private UsuarioModel usuario;
    
    // Clave Foránea 2: Relación con Resena
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idResena", nullable = false)
    private ResenaModel resena;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String contenido;

    @Column(name = "fechaPublicacion", insertable = false, updatable = false)
    private Timestamp fechaPublicacion; // DEFAULT CURRENT_TIMESTAMP
    
    // Constructor, Getters y Setters...

    public ComentarioResenaModel() {
    }

    // --- Getters y Setters ---

    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public ResenaModel getResena() {
        return resena;
    }

    public void setResena(ResenaModel resena) {
        this.resena = resena;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Timestamp getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Timestamp fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}
