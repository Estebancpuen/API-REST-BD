package com.apirest.backend.Controller;

import com.apirest.backend.Model.IncluyeModel;
import com.apirest.backend.Service.IIncluyeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController 
@RequestMapping("/api/inclusiones") // Prefijo base: http://localhost:8080/api/inclusiones
public class IncluyeController {

    @Autowired
    private IIncluyeService incluyeService;

    // POST: /api/inclusiones/crear
    @PostMapping("/crear")
    public ResponseEntity<IncluyeModel> crearInclusion(@RequestBody IncluyeModel inclusion) {
        return ResponseEntity.ok(incluyeService.guardarInclusion(inclusion));
    }

    // GET: /api/inclusiones/listar
    @GetMapping("/listar")
    public ResponseEntity<List<IncluyeModel>> obtenerInclusiones() {
        return ResponseEntity.ok(incluyeService.obtenerTodos());
    }

    // GET: /api/inclusiones/buscar/{id}
    @GetMapping("/buscar/{id}")
    public ResponseEntity<IncluyeModel> obtenerInclusionPorId(@PathVariable Integer id) {
        IncluyeModel inclusion = incluyeService.obtenerPorId(id);
        if (inclusion != null) {
            return ResponseEntity.ok(inclusion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT: /api/inclusiones/actualizar/{id}
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<IncluyeModel> actualizarInclusion(@PathVariable Integer id, @RequestBody IncluyeModel inclusion) {
        IncluyeModel actualizado = incluyeService.actualizarInclusion(id, inclusion);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE: /api/inclusiones/eliminar/{id}
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarInclusion(@PathVariable Integer id) {
        incluyeService.eliminarInclusion(id);
        return ResponseEntity.ok().build();
    }
}
