package com.apirest.backend.Model;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Foro")
public class ForoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idForo;

    // Relación con Usuario: Muchos a Uno (varios Foros pueden ser creados por el mismo Usuario)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", nullable = false)
    private UsuarioModel usuario;
    
    @Column(nullable = false)
    private Date fechaCreacion;

    // Mapeo del ENUM 'categoria'
    @Column(columnDefinition = "ENUM('genero','autor','tema')")
    private String categoria; // "genero", "autor", "tema"

    @Column(length = 300)
    private String descripcion;

    @Column(length = 200)
    private String titulo;
    
    // Constructor, Getters y Setters...

    public ForoModel() {
    }

    // --- Getters y Setters ---

    public Integer getIdForo() {
        return idForo;
    }

    public void setIdForo(Integer idForo) {
        this.idForo = idForo;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}