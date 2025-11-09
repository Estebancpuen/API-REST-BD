package com.apirest.backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.backend.Model.EmpleadoModel;
import com.apirest.backend.Service.IEmpleadoService;

@RestController
@RequestMapping ("/UAO/empleado")
public class EmpleadoController {

  @Autowired IEmpleadoService empleadoService;
  @PostMapping ("/insertar")
  ResponseEntity<EmpleadoModel> crearEmpleado(@RequestBody EmpleadoModel empleado ){
   return new ResponseEntity<EmpleadoModel>(empleadoService.guardarEmpleado(empleado),HttpStatus.CREATED);
  }

  @GetMapping("/listar")
  ResponseEntity<List<EmpleadoModel>> listarEmpleados(){
    return new ResponseEntity<List<EmpleadoModel>>(empleadoService.listarEmpleados(),HttpStatus.OK);
  }
  
  @GetMapping("/buscarEmpleado/{id}")
  ResponseEntity<EmpleadoModel> buscarEmpleado(@PathVariable Integer id){
    return new ResponseEntity<EmpleadoModel>(empleadoService.buscarEmpleadoPorId(id),HttpStatus.OK);
  }
 
  @DeleteMapping("/eliminar/{id}")
  ResponseEntity<String> eleiminarEmpleado(@PathVariable Integer id){
    return new ResponseEntity<String>(empleadoService.eliminarEmpleado(id),HttpStatus.OK);
  }
  
}
