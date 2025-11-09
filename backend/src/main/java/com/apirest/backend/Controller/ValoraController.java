package com.apirest.backend.Controller;

import com.apirest.backend.Model.ValoraModel;
import com.apirest.backend.Service.IValoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController 
@RequestMapping("/api/valoraciones") // Prefijo base: http://localhost:8080/api/valoraciones
public class ValoraController {

    @Autowired
    private IValoraService valoraService;

    // POST: /api/valoraciones/crear
    @PostMapping("/crear")
    public ResponseEntity<ValoraModel> crearValoracion(@RequestBody ValoraModel valoracion) {
        return ResponseEntity.ok(valoraService.guardarValoracion(valoracion));
    }

    // GET: /api/valoraciones/listar
    @GetMapping("/listar")
    public ResponseEntity<List<ValoraModel>> obtenerValoraciones() {
        return ResponseEntity.ok(valoraService.obtenerTodos());
    }

    // GET: /api/valoraciones/buscar/{id}
    @GetMapping("/buscar/{id}")
    public ResponseEntity<ValoraModel> obtenerValoracionPorId(@PathVariable Integer id) {
        ValoraModel valoracion = valoraService.obtenerPorId(id);
        if (valoracion != null) {
            return ResponseEntity.ok(valoracion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT: /api/valoraciones/actualizar/{id}
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ValoraModel> actualizarValoracion(@PathVariable Integer id, @RequestBody ValoraModel valoracion) {
        ValoraModel actualizado = valoraService.actualizarValoracion(id, valoracion);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE: /api/valoraciones/eliminar/{id}
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarValoracion(@PathVariable Integer id) {
        valoraService.eliminarValoracion(id);
        return ResponseEntity.ok().build();
    }
}
