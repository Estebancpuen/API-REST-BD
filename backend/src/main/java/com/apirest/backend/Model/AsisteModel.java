package com.apirest.backend.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Asiste")
public class AsisteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAsiste;

    // Clave Foránea 1: Relación con Usuario
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", nullable = false)
    private UsuarioModel usuario;
    
    // Clave Foránea 2: Relación con Reunion
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idReunion", nullable = false)
    private ReunionModel reunion;
    
    // Constructor, Getters y Setters...

    public AsisteModel() {
    }

    // --- Getters y Setters ---

    public Integer getIdAsiste() {
        return idAsiste;
    }

    public void setIdAsiste(Integer idAsiste) {
        this.idAsiste = idAsiste;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public ReunionModel getReunion() {
        return reunion;
    }

    public void setReunion(ReunionModel reunion) {
        this.reunion = reunion;
    }
}
