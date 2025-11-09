package com.apirest.backend.Controller;

import com.apirest.backend.Model.ComentarioResenaModel;
import com.apirest.backend.Service.IComentarioResenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController 
@RequestMapping("/api/comentarios-resena") // Prefijo base: http://localhost:8080/api/comentarios-resena
public class ComentarioResenaController {

    @Autowired
    private IComentarioResenaService comentarioResenaService;

    // POST: /api/comentarios-resena/crear
    @PostMapping("/crear")
    public ResponseEntity<ComentarioResenaModel> crearComentario(@RequestBody ComentarioResenaModel comentario) {
        return ResponseEntity.ok(comentarioResenaService.guardarComentario(comentario));
    }

    // GET: /api/comentarios-resena/listar
    @GetMapping("/listar")
    public ResponseEntity<List<ComentarioResenaModel>> obtenerComentarios() {
        return ResponseEntity.ok(comentarioResenaService.obtenerTodos());
    }

    // GET: /api/comentarios-resena/buscar/{id}
    @GetMapping("/buscar/{id}")
    public ResponseEntity<ComentarioResenaModel> obtenerComentarioPorId(@PathVariable Integer id) {
        ComentarioResenaModel comentario = comentarioResenaService.obtenerPorId(id);
        if (comentario != null) {
            return ResponseEntity.ok(comentario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT: /api/comentarios-resena/actualizar/{id}
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ComentarioResenaModel> actualizarComentario(@PathVariable Integer id, @RequestBody ComentarioResenaModel comentario) {
        ComentarioResenaModel actualizado = comentarioResenaService.actualizarComentario(id, comentario);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE: /api/comentarios-resena/eliminar/{id}
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarComentario(@PathVariable Integer id) {
        comentarioResenaService.eliminarComentario(id);
        return ResponseEntity.ok().build();
    }
}