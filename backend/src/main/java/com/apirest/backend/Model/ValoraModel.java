package com.apirest.backend.Model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Valora", uniqueConstraints = {
    // Mapeo de la clave UNIQUE KEY uq_usuario_resena (idUsuario, idResena)
    @UniqueConstraint(columnNames = {"idUsuario", "idResena"})
})
public class ValoraModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idValor;

    // Clave Foránea 1: Relación con Usuario
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", nullable = false)
    private UsuarioModel usuario;
    
    // Clave Foránea 2: Relación con Resena
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idResena", nullable = false)
    private ResenaModel resena;

    // BIT NOT NULL DEFAULT 1 se mapea a Boolean en Java
    @Column(columnDefinition = "BIT", nullable = false)
    private Boolean utilidad; 

    @Column(insertable = false, updatable = false)
    private Timestamp fecha; // DEFAULT CURRENT_TIMESTAMP
    
    // Constructor, Getters y Setters...

    public ValoraModel() {
    }

    // --- Getters y Setters ---

    public Integer getIdValor() {
        return idValor;
    }

    public void setIdValor(Integer idValor) {
        this.idValor = idValor;
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

    public Boolean getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(Boolean utilidad) {
        this.utilidad = utilidad;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    // No se necesita setFecha ya que es automático, pero lo dejamos por consistencia
    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
}