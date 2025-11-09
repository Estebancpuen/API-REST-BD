package com.apirest.backend.Controller;

import com.apirest.backend.Model.PropuestaLibroModel;
import com.apirest.backend.Service.IPropuestaLibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController 
@RequestMapping("/api/propuestas") // Prefijo base: http://localhost:8080/api/propuestas
public class PropuestaLibroController {

    @Autowired
    private IPropuestaLibroService propuestaLibroService;

    // POST: /api/propuestas/crear
    @PostMapping("/crear")
    public ResponseEntity<PropuestaLibroModel> crearPropuesta(@RequestBody PropuestaLibroModel propuesta) {
        return ResponseEntity.ok(propuestaLibroService.guardarPropuesta(propuesta));
    }

    // GET: /api/propuestas/listar
    @GetMapping("/listar")
    public ResponseEntity<List<PropuestaLibroModel>> obtenerPropuestas() {
        return ResponseEntity.ok(propuestaLibroService.obtenerTodos());
    }

    // GET: /api/propuestas/buscar/{id}
    @GetMapping("/buscar/{id}")
    public ResponseEntity<PropuestaLibroModel> obtenerPropuestaPorId(@PathVariable Integer id) {
        PropuestaLibroModel propuesta = propuestaLibroService.obtenerPorId(id);
        if (propuesta != null) {
            return ResponseEntity.ok(propuesta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT: /api/propuestas/actualizar/{id}
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<PropuestaLibroModel> actualizarPropuesta(@PathVariable Integer id, @RequestBody PropuestaLibroModel propuesta) {
        PropuestaLibroModel actualizado = propuestaLibroService.actualizarPropuesta(id, propuesta);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE: /api/propuestas/eliminar/{id}
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarPropuesta(@PathVariable Integer id) {
        propuestaLibroService.eliminarPropuesta(id);
        return ResponseEntity.ok().build();
    }
}