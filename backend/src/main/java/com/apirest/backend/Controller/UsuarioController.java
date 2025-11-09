package com.apirest.backend.Controller;

import com.apirest.backend.Model.UsuarioModel;
import com.apirest.backend.Service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; // Importación útil para respuestas más detalladas
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController 
@RequestMapping("/api/usuarios") // Prefijo base: http://localhost:8080/api/usuarios
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    // POST: /api/usuarios/crear
    @PostMapping("/crear")
    public ResponseEntity<UsuarioModel> crearUsuario(@RequestBody UsuarioModel usuario) {
        // ResponseEntity permite envolver la respuesta HTTP para mejor control
        return ResponseEntity.ok(usuarioService.guardarUsuario(usuario));
    }

    // GET: /api/usuarios/listar
    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioModel>> obtenerUsuarios() {
        return ResponseEntity.ok(usuarioService.obtenerTodos());
    }

    // GET: /api/usuarios/buscar/{id}
    @GetMapping("/buscar/{id}")
    public ResponseEntity<UsuarioModel> obtenerUsuarioPorId(@PathVariable Integer id) {
        UsuarioModel usuario = usuarioService.obtenerPorId(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            // Manejo simple para notificar que no se encontró el recurso
            return ResponseEntity.notFound().build(); 
        }
    }

    // PUT: /api/usuarios/actualizar/{id}
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<UsuarioModel> actualizarUsuario(@PathVariable Integer id, @RequestBody UsuarioModel usuario) {
        UsuarioModel actualizado = usuarioService.actualizarUsuario(id, usuario);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE: /api/usuarios/eliminar/{id}
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Integer id) {
        usuarioService.eliminarUsuario(id);
        // Retorna 200 OK (sin cuerpo) para una eliminación exitosa
        return ResponseEntity.ok().build(); 
    }
}
