package com.apirest.backend.Model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ComentarioForo")
public class ComentarioForoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComentario;

    // Relación recursiva: Un comentario puede ser respuesta de otro (comentarioPadre)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comentarioPadre") // Por defecto es nullable, como en tu SQL
    private ComentarioForoModel comentarioPadre; 
    
    // Clave Foránea 2: Relación con Usuario
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", nullable = false)
    private UsuarioModel usuario;
    
    // Clave Foránea 3: Relación con Foro
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idForo", nullable = false)
    private ForoModel foro;

    @Column(name = "fechaPublicacion", insertable = false, updatable = false)
    private Timestamp fechaPublicacion; // DEFAULT CURRENT_TIMESTAMP

    @Column(length = 2000, nullable = false)
    private String contenido;
    
    // Constructor, Getters y Setters...

    public ComentarioForoModel() {
    }

    // --- Getters y Setters ---

    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public ComentarioForoModel getComentarioPadre() {
        return comentarioPadre;
    }

    public void setComentarioPadre(ComentarioForoModel comentarioPadre) {
        this.comentarioPadre = comentarioPadre;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public ForoModel getForo() {
        return foro;
    }

    public void setForo(ForoModel foro) {
        this.foro = foro;
    }

    public Timestamp getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Timestamp fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}