package com.apirest.backend.Controller;

import com.apirest.backend.Model.ProgresoRetoModel;
import com.apirest.backend.Service.IProgresoRetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController 
@RequestMapping("/api/progresos") // Prefijo base: http://localhost:8080/api/progresos
public class ProgresoRetoController {

    @Autowired
    private IProgresoRetoService progresoRetoService;

    // POST: /api/progresos/crear
    @PostMapping("/crear")
    public ResponseEntity<ProgresoRetoModel> crearProgreso(@RequestBody ProgresoRetoModel progreso) {
        return ResponseEntity.ok(progresoRetoService.guardarProgreso(progreso));
    }

    // GET: /api/progresos/listar
    @GetMapping("/listar")
    public ResponseEntity<List<ProgresoRetoModel>> obtenerProgresos() {
        return ResponseEntity.ok(progresoRetoService.obtenerTodos());
    }

    // GET: /api/progresos/buscar/{id}
    @GetMapping("/buscar/{id}")
    public ResponseEntity<ProgresoRetoModel> obtenerProgresoPorId(@PathVariable Integer id) {
        ProgresoRetoModel progreso = progresoRetoService.obtenerPorId(id);
        if (progreso != null) {
            return ResponseEntity.ok(progreso);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT: /api/progresos/actualizar/{id}
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ProgresoRetoModel> actualizarProgreso(@PathVariable Integer id, @RequestBody ProgresoRetoModel progreso) {
        ProgresoRetoModel actualizado = progresoRetoService.actualizarProgreso(id, progreso);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE: /api/progresos/eliminar/{id}
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarProgreso(@PathVariable Integer id) {
        progresoRetoService.eliminarProgreso(id);
        return ResponseEntity.ok().build();
    }
}
