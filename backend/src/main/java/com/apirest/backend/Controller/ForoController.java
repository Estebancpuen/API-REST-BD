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

import com.apirest.backend.Model.ForoModel;
import com.apirest.backend.Service.IForoService;

@RestController 
@RequestMapping("/api/foros") // Prefijo base: http://localhost:8080/api/foros
public class ForoController {

    @Autowired
    private IForoService foroService;

    // POST: /api/foros/crear
    @PostMapping("/crear")
    public ResponseEntity<ForoModel> crearForo(@RequestBody ForoModel foro) {
        return ResponseEntity.ok(foroService.guardarForo(foro));
    }

    // GET: /api/foros/listar
    @GetMapping("/listar")
    public ResponseEntity<List<ForoModel>> obtenerForos() {
        return ResponseEntity.ok(foroService.obtenerTodos());
    }

    // GET: /api/foros/buscar/{id}
    @GetMapping("/buscar/{id}")
    public ResponseEntity<ForoModel> obtenerForoPorId(@PathVariable Integer id) {
        ForoModel foro = foroService.obtenerPorId(id);
        if (foro != null) {
            return ResponseEntity.ok(foro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT: /api/foros/actualizar/{id}
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ForoModel> actualizarForo(@PathVariable Integer id, @RequestBody ForoModel foro) {
        ForoModel actualizado = foroService.actualizarForo(id, foro);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE: /api/foros/eliminar/{id}
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarForo(@PathVariable Integer id) {
        foroService.eliminarForo(id);
        return ResponseEntity.ok().build();
    }
}
