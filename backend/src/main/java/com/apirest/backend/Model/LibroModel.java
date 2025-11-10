package com.apirest.backend.Model;

import java.sql.Date;

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
@Table(name = "Libro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibroModel {

    public enum EstadoLectura {
        pendiente,
        en_lectura,  // Mantiene el underscore en Java pero MySQL usa espacio
        leido
    }

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

    @Enumerated(EnumType.STRING)
    @Column(name = "estadoLectura", columnDefinition = "ENUM('pendiente','en_lectura','leido')")
    private EstadoLectura estadoLectura;

    private Date fechaSeleccion;
}
