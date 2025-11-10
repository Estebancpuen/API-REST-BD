package com.apirest.backend.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioModel {

    public enum Rol {
        lector,
        moderador,
        administrador
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(name = "nombreCompleto", length = 60, nullable = false)
    private String nombreCompleto;

    private Integer edad;

    @Column(length = 20)
    private String ocupacion;

    @Column(name = "correoElectronico", length = 60, unique = true, nullable = false)
    private String correoElectronico;

    @Column(length = 20)
    private String telefono;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('lector','moderador','administrador')", nullable = false)
    private Rol rol;
}
