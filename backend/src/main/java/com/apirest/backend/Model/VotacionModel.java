package com.apirest.backend.Model;

import java.sql.Date;

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
@Table(name = "Votacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VotacionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVotacion;

    // Clave Foránea 1: Relación con Usuario
    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private UsuarioModel usuario;
    
    // Clave Foránea 2: Relación con PropuestaLibro
    @ManyToOne
    @JoinColumn(name = "idPropuesta", nullable = false)
    private PropuestaLibroModel propuesta;

    private Date fechaVoto;

    @Column(columnDefinition = "BIT NOT NULL")
    private Boolean voto;
}
