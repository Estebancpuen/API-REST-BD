package com.apirest.backend.Model;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "Reunion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReunionModel {

    public enum Modalidad {
        presencial,
        virtual
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReunion;

    // Relación con Libro: Muchos a Uno (varias Reuniones pueden ser sobre el mismo Libro)
    @ManyToOne
    @JoinColumn(name = "idLibro", nullable = false)
    private LibroModel libro; 
    // Nota: El campo idLibro ya no se declara directamente como Integer; JPA lo maneja a través del objeto LibroModel.

    @Column(nullable = false)
    private Date fecha;

    private Time hora;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('presencial','virtual')")
    private Modalidad modalidad;

    @Column(name = "lugar_o_enlace", length = 500)
    private String lugarOEnlace;
}
