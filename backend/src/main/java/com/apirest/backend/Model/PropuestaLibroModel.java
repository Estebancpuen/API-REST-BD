package com.apirest.backend.Model;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "PropuestaLibro")
public class PropuestaLibroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPropuesta;

    // Clave Foránea 1: Relación con Usuario
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", nullable = false)
    private UsuarioModel usuario;
    
    // Clave Foránea 2: Relación con Libro
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLibro", nullable = false)
    private LibroModel libro;

    private Date fechaPropuesta;

    // Mapeo del ENUM 'estado'
    @Column(columnDefinition = "ENUM('propuesto','seleccionado','rechazado')")
    private String estado; // "propuesto", "seleccionado", "rechazado"

    private Date fechaDecision;
    
    // Constructor, Getters y Setters...

    public PropuestaLibroModel() {
    }

    // --- Getters y Setters ---

    public Integer getIdPropuesta() {
        return idPropuesta;
    }

    public void setIdPropuesta(Integer idPropuesta) {
        this.idPropuesta = idPropuesta;
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

    public Date getFechaPropuesta() {
        return fechaPropuesta;
    }

    public void setFechaPropuesta(Date fechaPropuesta) {
        this.fechaPropuesta = fechaPropuesta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaDecision() {
        return fechaDecision;
    }

    public void setFechaDecision(Date fechaDecision) {
        this.fechaDecision = fechaDecision;
    }
}
