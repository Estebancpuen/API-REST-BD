package com.apirest.backend.Model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ProgresoReto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgresoRetoModel {

    public enum EstadoProgreso {
        no_iniciado,
        en_progreso,
        completado
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProgreso;

    // Clave Foránea 1: Relación con Inscripcion
    @JoinColumn(name = "idInscripcion", nullable = false)
    private InscripcionModel inscripcion;
    
    // Clave Foránea 2: Relación con Libro
    @JoinColumn(name = "idLibro", nullable = false)
    private LibroModel libro;

    @Column(columnDefinition = "INT DEFAULT 0")
    private Integer porcentajeAvance; // 0 a 100

    private Date fechaActualizacion;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('no_iniciado','en_progreso','completado')")
    private EstadoProgreso estado;
}
