package com.apirest.backend.Controller;

import com.apirest.backend.Model.RetoLecturaModel;
import com.apirest.backend.Service.IRetoLecturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController 
@RequestMapping("/api/retos") // Prefijo base: http://localhost:8080/api/retos
public class RetoLecturaController {

    @Autowired
    private IRetoLecturaService retoLecturaService;

    // POST: /api/retos/crear
    @PostMapping("/crear")
    public ResponseEntity<RetoLecturaModel> crearReto(@RequestBody RetoLecturaModel reto) {
        return ResponseEntity.ok(retoLecturaService.guardarReto(reto));
    }

    // GET: /api/retos/listar
    @GetMapping("/listar")
    public ResponseEntity<List<RetoLecturaModel>> obtenerRetos() {
        return ResponseEntity.ok(retoLecturaService.obtenerTodos());
    }

    // GET: /api/retos/buscar/{id}
    @GetMapping("/buscar/{id}")
    public ResponseEntity<RetoLecturaModel> obtenerRetoPorId(@PathVariable Integer id) {
        RetoLecturaModel reto = retoLecturaService.obtenerPorId(id);
        if (reto != null) {
            return ResponseEntity.ok(reto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT: /api/retos/actualizar/{id}
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<RetoLecturaModel> actualizarReto(@PathVariable Integer id, @RequestBody RetoLecturaModel reto) {
        RetoLecturaModel actualizado = retoLecturaService.actualizarReto(id, reto);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE: /api/retos/eliminar/{id}
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarReto(@PathVariable Integer id) {
        retoLecturaService.eliminarReto(id);
        return ResponseEntity.ok().build();
    }
}
