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
@Table(name = "Foro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForoModel {

    public enum Categoria {
        genero,
        autor,
        tema
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idForo;

    // Relación con Usuario: Muchos a Uno (varios Foros pueden ser creados por el mismo Usuario)
    @JoinColumn(name = "idUsuario", nullable = false)
    private UsuarioModel usuario;
    
    @Column(nullable = false)
    private Date fechaCreacion;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('genero','autor','tema')")
    private Categoria categoria;

    @Column(length = 300)
    private String descripcion;

    @Column(length = 200)
    private String titulo;
}