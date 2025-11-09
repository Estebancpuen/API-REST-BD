package com.apirest.backend.Model;

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
@Table(name="vehiculo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto incremental del campo en la bd
    @Column(name="idVehiculo")
    private Integer idVehiculo;
    private String matricula;
    private String marca;
    private String modelo;
    //simular la relación 1:N de empleado y vehiculo
    @ManyToOne
    @JoinColumn(name = "empleadoId")
    private EmpleadoModel empleado;
}
