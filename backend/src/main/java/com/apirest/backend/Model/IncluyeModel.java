package com.apirest.backend.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Incluye", uniqueConstraints = {
    // Mapeo de la clave UNIQUE (idLibro, idReto)
    @UniqueConstraint(columnNames = {"idLibro", "idReto"})
})
public class IncluyeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idIncluye;

    // Clave Foránea 1: Relación con Libro
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLibro", nullable = false)
    private LibroModel libro;
    
    // Clave Foránea 2: Relación con RetoLectura
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idReto", nullable = false)
    private RetoLecturaModel reto;
    
    // Constructor, Getters y Setters...

    public IncluyeModel() {
    }

    // --- Getters y Setters ---

    public Integer getIdIncluye() {
        return idIncluye;
    }

    public void setIdIncluye(Integer idIncluye) {
        this.idIncluye = idIncluye;
    }

    public LibroModel getLibro() {
        return libro;
    }

    public void setLibro(LibroModel libro) {
        this.libro = libro;
    }

    public RetoLecturaModel getReto() {
        return reto;
    }

    public void setReto(RetoLecturaModel reto) {
        this.reto = reto;
    }
}
