package com.apirest.backend.Controller;

import com.apirest.backend.Model.ReunionModel;
import com.apirest.backend.Service.IReunionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController 
@RequestMapping("/api/reuniones") // Prefijo base: http://localhost:8080/api/reuniones
public class ReunionController {

    @Autowired
    private IReunionService reunionService;

    // POST: /api/reuniones/crear
    @PostMapping("/crear")
    public ResponseEntity<ReunionModel> crearReunion(@RequestBody ReunionModel reunion) {
        return ResponseEntity.ok(reunionService.guardarReunion(reunion));
    }

    // GET: /api/reuniones/listar
    @GetMapping("/listar")
    public ResponseEntity<List<ReunionModel>> obtenerReuniones() {
        return ResponseEntity.ok(reunionService.obtenerTodos());
    }

    // GET: /api/reuniones/buscar/{id}
    @GetMapping("/buscar/{id}")
    public ResponseEntity<ReunionModel> obtenerReunionPorId(@PathVariable Integer id) {
        ReunionModel reunion = reunionService.obtenerPorId(id);
        if (reunion != null) {
            return ResponseEntity.ok(reunion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT: /api/reuniones/actualizar/{id}
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ReunionModel> actualizarReunion(@PathVariable Integer id, @RequestBody ReunionModel reunion) {
        ReunionModel actualizado = reunionService.actualizarReunion(id, reunion);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE: /api/reuniones/eliminar/{id}
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarReunion(@PathVariable Integer id) {
        reunionService.eliminarReunion(id);
        return ResponseEntity.ok().build();
    }
}
