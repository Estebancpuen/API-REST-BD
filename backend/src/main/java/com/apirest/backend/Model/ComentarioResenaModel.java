package com.apirest.backend.Model;

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
@Table(name = "ComentarioResena")
public class ComentarioResenaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComentario;

    // Clave Foránea 1: Relación con Usuario
    @JoinColumn(name = "idUsuario", nullable = false)
    private UsuarioModel usuario;
    
    // Clave Foránea 2: Relación con Resena
    @JoinColumn(name = "idResena", nullable = false)
    private ResenaModel resena;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String contenido;

    @Column(name = "fechaPublicacion", insertable = false, updatable = false)
    private Timestamp fechaPublicacion; // DEFAULT CURRENT_TIMESTAMP
    
    // No necesitamos constructores, getters ni setters gracias a Lombok
}
