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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PropuestaLibro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropuestaLibroModel {

    public enum EstadoPropuesta {
        propuesto,
        seleccionado,
        rechazado
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPropuesta;

    // Clave Foránea 1: Relación con Usuario
    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private UsuarioModel usuario;
    
    // Clave Foránea 2: Relación con Libro
    @ManyToOne
    @JoinColumn(name = "idLibro", nullable = false)
    private LibroModel libro;

    private Date fechaPropuesta;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('propuesto','seleccionado','rechazado')")
    private EstadoPropuesta estado;

    private Date fechaDecision;
}
