package com.apirest.backend.Model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "Valora", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idUsuario", "idResena"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValoraModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idValor;

    // Clave Foránea 1: Relación con Usuario
    @JoinColumn(name = "idUsuario", nullable = false)
    private UsuarioModel usuario;
    
    // Clave Foránea 2: Relación con Resena
    @JoinColumn(name = "idResena", nullable = false)
    private ResenaModel resena;

    @Column(columnDefinition = "BIT NOT NULL DEFAULT 1")
    private Boolean utilidad;

    @Column(insertable = false, updatable = false)
    private Timestamp fecha;
}