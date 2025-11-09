package com.apirest.backend.Controller;

import com.apirest.backend.Model.ResenaModel;
import com.apirest.backend.Service.IResenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController 
@RequestMapping("/api/resenas") // Prefijo base: http://localhost:8080/api/resenas
public class ResenaController {

    @Autowired
    private IResenaService resenaService;

    // POST: /api/resenas/crear
    @PostMapping("/crear")
    public ResponseEntity<ResenaModel> crearResena(@RequestBody ResenaModel resena) {
        ResenaModel nuevaResena = resenaService.guardarResena(resena);
        if (nuevaResena != null) {
            return ResponseEntity.ok(nuevaResena);
        } else {
            return ResponseEntity.badRequest().build(); // Retorna 400 si la validación falla en el servicio
        }
    }

    // GET: /api/resenas/listar
    @GetMapping("/listar")
    public ResponseEntity<List<ResenaModel>> obtenerResenas() {
        return ResponseEntity.ok(resenaService.obtenerTodos());
    }

    // GET: /api/resenas/buscar/{id}
    @GetMapping("/buscar/{id}")
    public ResponseEntity<ResenaModel> obtenerResenaPorId(@PathVariable Integer id) {
        ResenaModel resena = resenaService.obtenerPorId(id);
        if (resena != null) {
            return ResponseEntity.ok(resena);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT: /api/resenas/actualizar/{id}
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ResenaModel> actualizarResena(@PathVariable Integer id, @RequestBody ResenaModel resena) {
        ResenaModel actualizado = resenaService.actualizarResena(id, resena);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE: /api/resenas/eliminar/{id}
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarResena(@PathVariable Integer id) {
        resenaService.eliminarResena(id);
        return ResponseEntity.ok().build();
    }
}
