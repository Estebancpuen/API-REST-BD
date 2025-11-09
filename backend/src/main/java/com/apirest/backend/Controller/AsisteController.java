package com.apirest.backend.Controller;

import com.apirest.backend.Model.AsisteModel;
import com.apirest.backend.Service.IAsisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController 
@RequestMapping("/api/asistencias") // Prefijo base: http://localhost:8080/api/asistencias
public class AsisteController {

    @Autowired
    private IAsisteService asisteService;

    // POST: /api/asistencias/crear
    @PostMapping("/crear")
    public ResponseEntity<AsisteModel> crearAsistencia(@RequestBody AsisteModel asistencia) {
        return ResponseEntity.ok(asisteService.guardarAsistencia(asistencia));
    }

    // GET: /api/asistencias/listar
    @GetMapping("/listar")
    public ResponseEntity<List<AsisteModel>> obtenerAsistencias() {
        return ResponseEntity.ok(asisteService.obtenerTodos());
    }

    // GET: /api/asistencias/buscar/{id}
    @GetMapping("/buscar/{id}")
    public ResponseEntity<AsisteModel> obtenerAsistenciaPorId(@PathVariable Integer id) {
        AsisteModel asistencia = asisteService.obtenerPorId(id);
        if (asistencia != null) {
            return ResponseEntity.ok(asistencia);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT: /api/asistencias/actualizar/{id}
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<AsisteModel> actualizarAsistencia(@PathVariable Integer id, @RequestBody AsisteModel asistencia) {
        AsisteModel actualizado = asisteService.actualizarAsistencia(id, asistencia);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE: /api/asistencias/eliminar/{id}
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarAsistencia(@PathVariable Integer id) {
        asisteService.eliminarAsistencia(id);
        return ResponseEntity.ok().build();
    }
}
