package com.apirest.backend.Model;

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
@Table(name = "Incluye", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idLibro", "idReto"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncluyeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idIncluye;

    // Clave Foránea 1: Relación con Libro
    @JoinColumn(name = "idLibro", nullable = false)
    private LibroModel libro;
    
    // Clave Foránea 2: Relación con RetoLectura
    @JoinColumn(name = "idReto", nullable = false)
    private RetoLecturaModel reto;
    

}
