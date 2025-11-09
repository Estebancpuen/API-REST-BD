package com.apirest.backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.backend.Model.VehiculoModel;
import com.apirest.backend.Service.IVehiculoService;

@RestController
@RequestMapping("/UAO/vehiculo")
public class VehiculoController {
    @Autowired IVehiculoService vehiculoService;
    @PostMapping("/insertar")
    ResponseEntity<VehiculoModel> crearVehiculo(@RequestBody VehiculoModel vehiculo){
        return new ResponseEntity<VehiculoModel>(vehiculoService.crearVehiculo(vehiculo),HttpStatus.CREATED);
    }
    @GetMapping("/listar")
    ResponseEntity<List<VehiculoModel>> listaVihiculos(){
        return new ResponseEntity<List<VehiculoModel>>(vehiculoService.listarVehiculos(),HttpStatus.OK);
    }
}
