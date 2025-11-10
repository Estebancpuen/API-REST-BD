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
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Inscripcion", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idUsuario", "idReto"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InscripcionModel {

    public enum EstadoInscripcion {
        activa,
        finalizada,
        cancelada
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInscripcion;

    // Clave Foránea 1: Relación con Usuario
    @JoinColumn(name = "idUsuario", nullable = false)
    private UsuarioModel usuario;
    
    // Clave Foránea 2: Relación con RetoLectura
    @JoinColumn(name = "idReto", nullable = false)
    private RetoLecturaModel reto;

    private Date fecha; // Fecha de inscripción

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('activa','finalizada','cancelada')")
    private EstadoInscripcion estadoInscripcion;
}
