package com.apirest.backend.Model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ArchivoAdjunto")
public class ArchivoAdjuntoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idArchivo;

    // Clave Foránea 1: Relación con Reunion (NULLABLE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idReunion", nullable = true)
    private ReunionModel reunion;
    
    // Clave Foránea 2: Relación con Resena (NULLABLE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idResena", nullable = true)
    private ResenaModel resena;

    // Mapeo del ENUM 'tipo'
    @Column(columnDefinition = "ENUM('acta_pdf','presentacion','imagen_evento','imagen_cita','nota_manuscrita','ilustracion','otro')")
    private String tipo;

    @Column(length = 250)
    private String nombre;

    @Column(length = 1000, nullable = false)
    private String url;

    @Column(name = "fechaSubida", insertable = false, updatable = false)
    private Timestamp fechaSubida; // DEFAULT CURRENT_TIMESTAMP
    
    // Constructor, Getters y Setters...

    public ArchivoAdjuntoModel() {
    }

    // --- Getters y Setters ---

    public Integer getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(Integer idArchivo) {
        this.idArchivo = idArchivo;
    }

    public ReunionModel getReunion() {
        return reunion;
    }

    public void setReunion(ReunionModel reunion) {
        this.reunion = reunion;
    }

    public ResenaModel getResena() {
        return resena;
    }

    public void setResena(ResenaModel resena) {
        this.resena = resena;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Timestamp getFechaSubida() {
        return fechaSubida;
    }

    public void setFechaSubida(Timestamp fechaSubida) {
        this.fechaSubida = fechaSubida;
    }
}
