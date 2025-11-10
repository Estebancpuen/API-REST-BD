package com.apirest.backend.Model;

import java.sql.Timestamp;

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
@Table(name = "ArchivoAdjunto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArchivoAdjuntoModel {

    public enum TipoArchivo {
        acta_pdf,
        presentacion,
        imagen_evento,
        imagen_cita,
        nota_manuscrita,
        ilustracion,
        otro
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idArchivo;

    // Clave Foránea 1: Relación con Reunion (NULLABLE)
    @JoinColumn(name = "idReunion", nullable = true)
    private ReunionModel reunion;
    
    // Clave Foránea 2: Relación con Resena (NULLABLE)
    @JoinColumn(name = "idResena", nullable = true)
    private ResenaModel resena;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('acta_pdf','presentacion','imagen_evento','imagen_cita','nota_manuscrita','ilustracion','otro')")
    private TipoArchivo tipo;

    @Column(length = 250)
    private String nombre;

    @Column(length = 1000, nullable = false)
    private String url;

    @Column(name = "fechaSubida", insertable = false, updatable = false)
    private Timestamp fechaSubida;
}
