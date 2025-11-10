package com.apirest.backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.backend.Model.InscripcionModel;
import com.apirest.backend.Service.IInscripcionService;

@RestController 
@RequestMapping("/api/inscripciones") // Prefijo base: http://localhost:8080/api/inscripciones
public class InscripcionController {

    @Autowired
    private IInscripcionService inscripcionService;

    // POST: /api/inscripciones/crear
    @PostMapping("/crear")
    public ResponseEntity<InscripcionModel> crearInscripcion(@RequestBody InscripcionModel inscripcion) {
        return ResponseEntity.ok(inscripcionService.guardarInscripcion(inscripcion));
    }

    // GET: /api/inscripciones/listar
    @GetMapping("/listar")
    public ResponseEntity<List<InscripcionModel>> obtenerInscripciones() {
        return ResponseEntity.ok(inscripcionService.obtenerTodos());
    }

    // GET: /api/inscripciones/buscar/{id}
    @GetMapping("/buscar/{id}")
    public ResponseEntity<InscripcionModel> obtenerInscripcionPorId(@PathVariable Integer id) {
        InscripcionModel inscripcion = inscripcionService.obtenerPorId(id);
        if (inscripcion != null) {
            return ResponseEntity.ok(inscripcion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT: /api/inscripciones/actualizar/{id}
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<InscripcionModel> actualizarInscripcion(@PathVariable Integer id, @RequestBody InscripcionModel inscripcion) {
        InscripcionModel actualizado = inscripcionService.actualizarInscripcion(id, inscripcion);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE: /api/inscripciones/eliminar/{id}
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarInscripcion(@PathVariable Integer id) {
        inscripcionService.eliminarInscripcion(id);
        return ResponseEntity.ok().build();
    }
}
