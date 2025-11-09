package com.apirest.backend.Controller;

import com.apirest.backend.Model.LibroModel;
import com.apirest.backend.Service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController 
@RequestMapping("/api/libros") // Prefijo base: http://localhost:8080/api/libros
public class LibroController {

    @Autowired
    private ILibroService libroService;

    // POST: /api/libros/crear
    @PostMapping("/crear")
    public ResponseEntity<LibroModel> crearLibro(@RequestBody LibroModel libro) {
        return ResponseEntity.ok(libroService.guardarLibro(libro));
    }

    // GET: /api/libros/listar
    @GetMapping("/listar")
    public ResponseEntity<List<LibroModel>> obtenerLibros() {
        return ResponseEntity.ok(libroService.obtenerTodos());
    }

    // GET: /api/libros/buscar/{id}
    @GetMapping("/buscar/{id}")
    public ResponseEntity<LibroModel> obtenerLibroPorId(@PathVariable Integer id) {
        LibroModel libro = libroService.obtenerPorId(id);
        if (libro != null) {
            return ResponseEntity.ok(libro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT: /api/libros/actualizar/{id}
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<LibroModel> actualizarLibro(@PathVariable Integer id, @RequestBody LibroModel libro) {
        LibroModel actualizado = libroService.actualizarLibro(id, libro);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE: /api/libros/eliminar/{id}
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Integer id) {
        libroService.eliminarLibro(id);
        return ResponseEntity.ok().build();
    }
}
