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

import com.apirest.backend.Model.ComentarioForoModel;
import com.apirest.backend.Service.IComentarioForoService;

@RestController 
@RequestMapping("/api/comentarios-foro") // Prefijo base: http://localhost:8080/api/comentarios-foro
public class ComentarioForoController {

    @Autowired
    private IComentarioForoService comentarioForoService;

    // POST: /api/comentarios-foro/crear
    @PostMapping("/crear")
    public ResponseEntity<ComentarioForoModel> crearComentario(@RequestBody ComentarioForoModel comentario) {
        return ResponseEntity.ok(comentarioForoService.guardarComentario(comentario));
    }

    // GET: /api/comentarios-foro/listar
    @GetMapping("/listar")
    public ResponseEntity<List<ComentarioForoModel>> obtenerComentarios() {
        return ResponseEntity.ok(comentarioForoService.obtenerTodos());
    }

    // GET: /api/comentarios-foro/buscar/{id}
    @GetMapping("/buscar/{id}")
    public ResponseEntity<ComentarioForoModel> obtenerComentarioPorId(@PathVariable Integer id) {
        ComentarioForoModel comentario = comentarioForoService.obtenerPorId(id);
        if (comentario != null) {
            return ResponseEntity.ok(comentario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT: /api/comentarios-foro/actualizar/{id}
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ComentarioForoModel> actualizarComentario(@PathVariable Integer id, @RequestBody ComentarioForoModel comentario) {
        ComentarioForoModel actualizado = comentarioForoService.actualizarComentario(id, comentario);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE: /api/comentarios-foro/eliminar/{id}
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarComentario(@PathVariable Integer id) {
        comentarioForoService.eliminarComentario(id);
        return ResponseEntity.ok().build();
    }
}
