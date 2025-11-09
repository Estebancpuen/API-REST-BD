package com.apirest.backend.Controller;

import com.apirest.backend.Model.ArchivoAdjuntoModel;
import com.apirest.backend.Service.IArchivoAdjuntoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController 
@RequestMapping("/api/archivos") // Prefijo base: http://localhost:8080/api/archivos
public class ArchivoAdjuntoController {

    @Autowired
    private IArchivoAdjuntoService archivoAdjuntoService;

    // POST: /api/archivos/crear
    @PostMapping("/crear")
    public ResponseEntity<ArchivoAdjuntoModel> crearArchivo(@RequestBody ArchivoAdjuntoModel archivo) {
        ArchivoAdjuntoModel nuevoArchivo = archivoAdjuntoService.guardarArchivo(archivo);
        if (nuevoArchivo != null) {
             return ResponseEntity.ok(nuevoArchivo);
        } else {
             return ResponseEntity.badRequest().build(); // 400 Bad Request si falla la validación
        }
    }

    // GET: /api/archivos/listar
    @GetMapping("/listar")
    public ResponseEntity<List<ArchivoAdjuntoModel>> obtenerArchivos() {
        return ResponseEntity.ok(archivoAdjuntoService.obtenerTodos());
    }

    // GET: /api/archivos/buscar/{id}
    @GetMapping("/buscar/{id}")
    public ResponseEntity<ArchivoAdjuntoModel> obtenerArchivoPorId(@PathVariable Integer id) {
        ArchivoAdjuntoModel archivo = archivoAdjuntoService.obtenerPorId(id);
        if (archivo != null) {
            return ResponseEntity.ok(archivo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT: /api/archivos/actualizar/{id}
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ArchivoAdjuntoModel> actualizarArchivo(@PathVariable Integer id, @RequestBody ArchivoAdjuntoModel archivo) {
        ArchivoAdjuntoModel actualizado = archivoAdjuntoService.actualizarArchivo(id, archivo);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            // Puede ser notFound o badRequest (si falla la validación)
            return ResponseEntity.badRequest().build(); 
        }
    }

    // DELETE: /api/archivos/eliminar/{id}
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarArchivo(@PathVariable Integer id) {
        archivoAdjuntoService.eliminarArchivo(id);
        return ResponseEntity.ok().build();
    }
}
