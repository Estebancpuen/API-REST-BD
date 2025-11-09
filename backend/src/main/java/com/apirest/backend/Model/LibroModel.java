package com.apirest.backend.Model;

import jakarta.persistence.*;
import java.sql.Date; // Usaremos java.sql.Date para mapear el tipo DATE de MySQL

@Entity
@Table(name = "Libro")
public class LibroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLibro;

    @Column(length = 100, nullable = false)
    private String titulo;

    @Column(length = 100)
    private String autor;

    @Column(length = 300)
    private String genero;

    @Column(name = "anoPublicacion", columnDefinition = "YEAR")
    private Integer anoPublicacion; 

    @Column(length = 300)
    private String sinopsis;

    @Column(length = 30)
    private String portada;

    // Mapeo del ENUM 'estadoLectura'
    @Column(name = "estadoLectura", columnDefinition = "ENUM('pendiente','en lectura','leido')")
    private String estadoLectura; // "pendiente", "en lectura", "leido"

    private Date fechaSeleccion; 

    
    public LibroModel() {
    }


    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getAnoPublicacion() {
        return anoPublicacion;
    }

    public void setAnoPublicacion(Integer anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getEstadoLectura() {
        return estadoLectura;
    }

    public void setEstadoLectura(String estadoLectura) {
        this.estadoLectura = estadoLectura;
    }

    public Date getFechaSeleccion() {
        return fechaSeleccion;
    }

    public void setFechaSeleccion(Date fechaSeleccion) {
        this.fechaSeleccion = fechaSeleccion;
    }
}
