package com.apirest.backend.Model;

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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Asiste")
public class AsisteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAsiste;

    // Clave Foránea 1: Relación con Usuario
    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private UsuarioModel usuario;
    
    // Clave Foránea 2: Relación con Reunion
    @ManyToOne
    @JoinColumn(name = "idReunion", nullable = false)
    private ReunionModel reunion;
    
    // No necesitamos constructores, getters ni setters gracias a Lombok
}
