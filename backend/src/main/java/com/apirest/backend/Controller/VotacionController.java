package com.apirest.backend.Controller;

import com.apirest.backend.Model.VotacionModel;
import com.apirest.backend.Service.IVotacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController 
@RequestMapping("/api/votaciones") // Prefijo base: http://localhost:8080/api/votaciones
public class VotacionController {

    @Autowired
    private IVotacionService votacionService;

    // POST: /api/votaciones/crear
    @PostMapping("/crear")
    public ResponseEntity<VotacionModel> crearVotacion(@RequestBody VotacionModel votacion) {
        return ResponseEntity.ok(votacionService.guardarVotacion(votacion));
    }

    // GET: /api/votaciones/listar
    @GetMapping("/listar")
    public ResponseEntity<List<VotacionModel>> obtenerVotaciones() {
        return ResponseEntity.ok(votacionService.obtenerTodos());
    }

    // GET: /api/votaciones/buscar/{id}
    @GetMapping("/buscar/{id}")
    public ResponseEntity<VotacionModel> obtenerVotacionPorId(@PathVariable Integer id) {
        VotacionModel votacion = votacionService.obtenerPorId(id);
        if (votacion != null) {
            return ResponseEntity.ok(votacion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT: /api/votaciones/actualizar/{id}
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<VotacionModel> actualizarVotacion(@PathVariable Integer id, @RequestBody VotacionModel votacion) {
        VotacionModel actualizado = votacionService.actualizarVotacion(id, votacion);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE: /api/votaciones/eliminar/{id}
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarVotacion(@PathVariable Integer id) {
        votacionService.eliminarVotacion(id);
        return ResponseEntity.ok().build();
    }
}
