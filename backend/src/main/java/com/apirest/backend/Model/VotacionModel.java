package com.apirest.backend.Model;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Votacion")
public class VotacionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVotacion;

    // Clave Foránea 1: Relación con Usuario
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", nullable = false)
    private UsuarioModel usuario;
    
    // Clave Foránea 2: Relación con PropuestaLibro
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPropuesta", nullable = false)
    private PropuestaLibroModel propuesta;

    private Date fechaVoto;

    // Mapeo del ENUM 'voto'
    @Column(columnDefinition = "ENUM('si','no')")
    private String voto; // "si", "no"
    
    // Constructor, Getters y Setters...

    public VotacionModel() {
    }

    // --- Getters y Setters ---

    public Integer getIdVotacion() {
        return idVotacion;
    }

    public void setIdVotacion(Integer idVotacion) {
        this.idVotacion = idVotacion;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public PropuestaLibroModel getPropuesta() {
        return propuesta;
    }

    public void setPropuesta(PropuestaLibroModel propuesta) {
        this.propuesta = propuesta;
    }

    public Date getFechaVoto() {
        return fechaVoto;
    }

    public void setFechaVoto(Date fechaVoto) {
        this.fechaVoto = fechaVoto;
    }

    public String getVoto() {
        return voto;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }
}
