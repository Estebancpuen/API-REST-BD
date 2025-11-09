package com.apirest.backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "empleado")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoModel {
    @Id
    private Integer idEmpleado;
    private String nombre;
    private Integer edad;
}
