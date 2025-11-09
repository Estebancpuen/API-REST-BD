package com.apirest.backend.Model;

import jakarta.persistence.*;
import java.sql.Date;
import java.sql.Time; // Para el tipo TIME de MySQL

@Entity
@Table(name = "Reunion")
public class ReunionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReunion;

    // Relación con Libro: Muchos a Uno (varias Reuniones pueden ser sobre el mismo Libro)
    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "idLibro", nullable = false)
    private LibroModel libro; 
    // Nota: El campo idLibro ya no se declara directamente como Integer; JPA lo maneja a través del objeto LibroModel.

    @Column(nullable = false)
    private Date fecha;

    private Time hora;

    // Mapeo del ENUM 'modalidad'
    @Column(columnDefinition = "ENUM('presencial','virtual')")
    private String modalidad; // "presencial", "virtual"

    @Column(name = "lugar_o_enlace", length = 500)
    private String lugarOEnlace;
    
    // Constructor, Getters y Setters...

    public ReunionModel() {
    }

    // --- Getters y Setters ---

    public Integer getIdReunion() {
        return idReunion;
    }

    public void setIdReunion(Integer idReunion) {
        this.idReunion = idReunion;
    }

    public LibroModel getLibro() {
        return libro;
    }

    public void setLibro(LibroModel libro) {
        this.libro = libro;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getLugarOEnlace() {
        return lugarOEnlace;
    }

    public void setLugarOEnlace(String lugarOEnlace) {
        this.lugarOEnlace = lugarOEnlace;
    }
}
