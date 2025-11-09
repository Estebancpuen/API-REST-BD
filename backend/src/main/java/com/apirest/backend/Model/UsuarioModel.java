// src/main/java/com/apirest/backend/Model/UsuarioModel.java

package com.apirest.backend.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuario")
public class UsuarioModel {

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
    private String rol; 

    
    public UsuarioModel() {
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
