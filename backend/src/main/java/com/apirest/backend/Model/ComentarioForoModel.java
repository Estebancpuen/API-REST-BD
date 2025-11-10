package com.apirest.backend.Model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "ComentarioForo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComentarioForoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComentario;

    // Relación recursiva: Un comentario puede ser respuesta de otro (comentarioPadre)
    @ManyToOne
    @JoinColumn(name = "comentarioPadre") // Por defecto es nullable, como en tu SQL
    private ComentarioForoModel comentarioPadre; 
    
    // Clave Foránea 2: Relación con Usuario
    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private UsuarioModel usuario;
    
    // Clave Foránea 3: Relación con Foro
    @ManyToOne
    @JoinColumn(name = "idForo", nullable = false)
    private ForoModel foro;

    @Column(name = "fechaPublicacion", insertable = false, updatable = false)
    private Timestamp fechaPublicacion; // DEFAULT CURRENT_TIMESTAMP

    @Column(length = 2000, nullable = false)
    private String contenido;
}