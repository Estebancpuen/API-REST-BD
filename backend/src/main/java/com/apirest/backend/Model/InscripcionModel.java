package com.apirest.backend.Model;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Inscripcion", uniqueConstraints = {
    // Mapeo de la clave UNIQUE KEY uq_usuario_reto (idUsuario, idReto)
    @UniqueConstraint(columnNames = {"idUsuario", "idReto"})
})
public class InscripcionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInscripcion;

    // Clave Foránea 1: Relación con Usuario
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", nullable = false)
    private UsuarioModel usuario;
    
    // Clave Foránea 2: Relación con RetoLectura
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idReto", nullable = false)
    private RetoLecturaModel reto;

    private Date fecha; // Fecha de inscripción

    // Mapeo del ENUM 'estadoInscripcion'
    @Column(columnDefinition = "ENUM('activa','finalizada','cancelada')")
    private String estadoInscripcion; // "activa", "finalizada", "cancelada"
    
    // Constructor, Getters y Setters...

    public InscripcionModel() {
    }

    // --- Getters y Setters ---

    public Integer getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(Integer idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public RetoLecturaModel getReto() {
        return reto;
    }

    public void setReto(RetoLecturaModel reto) {
        this.reto = reto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstadoInscripcion() {
        return estadoInscripcion;
    }

    public void setEstadoInscripcion(String estadoInscripcion) {
        this.estadoInscripcion = estadoInscripcion;
    }
}
