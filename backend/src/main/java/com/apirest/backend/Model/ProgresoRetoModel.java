package com.apirest.backend.Model;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ProgresoReto")
public class ProgresoRetoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProgreso;

    // Clave Foránea 1: Relación con Inscripcion
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idInscripcion", nullable = false)
    private InscripcionModel inscripcion;
    
    // Clave Foránea 2: Relación con Libro
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLibro", nullable = false)
    private LibroModel libro;

    @Column(columnDefinition = "INT DEFAULT 0")
    private Integer porcentajeAvance; // 0 a 100

    private Date fechaActualizacion;

    // Mapeo del ENUM 'estado'
    @Column(columnDefinition = "ENUM('no_iniciado','en_progreso','completado')")
    private String estado; // "no_iniciado", "en_progreso", "completado"
    
    // Constructor, Getters y Setters...

    public ProgresoRetoModel() {
    }

    // --- Getters y Setters ---

    public Integer getIdProgreso() {
        return idProgreso;
    }

    public void setIdProgreso(Integer idProgreso) {
        this.idProgreso = idProgreso;
    }

    public InscripcionModel getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(InscripcionModel inscripcion) {
        this.inscripcion = inscripcion;
    }

    public LibroModel getLibro() {
        return libro;
    }

    public void setLibro(LibroModel libro) {
        this.libro = libro;
    }

    public Integer getPorcentajeAvance() {
        return porcentajeAvance;
    }

    public void setPorcentajeAvance(Integer porcentajeAvance) {
        // Validación en el modelo (opcional, se recomienda también en el servicio)
        if (porcentajeAvance != null && (porcentajeAvance < 0 || porcentajeAvance > 100)) {
            throw new IllegalArgumentException("El porcentaje de avance debe estar entre 0 y 100.");
        }
        this.porcentajeAvance = porcentajeAvance;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
