package com.apirest.backend.Model;

import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Resena")
public class ResenaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idResena;

    // Clave Foránea 1: Relación con Usuario
    @JoinColumn(name = "idUsuario", nullable = false)
    private UsuarioModel usuario;
    
    // Clave Foránea 2: Relación con Libro
    @JoinColumn(name = "idLibro", nullable = false)
    private LibroModel libro;

    @Column(nullable = false)
    private Date fecha;

    @Column(columnDefinition = "TEXT")
    private String opinion;

    // La validación CHECK (calificacion BETWEEN 1 AND 5) debe manejarse a nivel de la aplicación/servicio, aunque JPA soporta @Column(columnDefinition = "INT CHECK (calificacion BETWEEN 1 AND 5)")
    @Column(nullable = false)
    private Integer calificacion; 

    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt; // Se manejará automáticamente por la DB (DEFAULT CURRENT_TIMESTAMP)
    
    // No necesitamos constructores, getters ni setters gracias a Lombok
}