package com.apirest.backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.Model.ArchivoAdjuntoModel;
import com.apirest.backend.Repository.ArchivoAdjuntoRepository;

@Service
public class ArchivoAdjuntoServiceImp implements IArchivoAdjuntoService {

    @Autowired
    private ArchivoAdjuntoRepository archivoAdjuntoRepository;

    /**
     * Verifica que el archivo esté asociado a UNA SOLA entidad (Reunion o Resena).
     */
    private boolean esValido(ArchivoAdjuntoModel archivo) {
        boolean reunionPresente = archivo.getReunion() != null && archivo.getReunion().getIdReunion() != null;
        boolean resenaPresente = archivo.getResena() != null && archivo.getResena().getIdResena() != null;
        
        // Debe ser (TRUE XOR FALSE) o (FALSE XOR TRUE). No puede ser (TRUE AND TRUE) ni (FALSE AND FALSE)
        return reunionPresente ^ resenaPresente;
    }

    @Override
    public List<ArchivoAdjuntoModel> obtenerTodos() {
        return archivoAdjuntoRepository.findAll();
    }

    @Override
    public ArchivoAdjuntoModel guardarArchivo(ArchivoAdjuntoModel archivo) {

        if (!esValido(archivo)) {
            throw new IllegalArgumentException("Un Archivo Adjunto debe estar ligado exactamente a una Reunion o una Reseña, pero no a ambas");
        }
        return archivoAdjuntoRepository.save(archivo);
    }

    @Override
    public ArchivoAdjuntoModel obtenerPorId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser null");
        }
        Optional<ArchivoAdjuntoModel> archivo = archivoAdjuntoRepository.findById(id);
        return archivo.orElse(null);
    }

    @Override
    public ArchivoAdjuntoModel actualizarArchivo(Integer id, ArchivoAdjuntoModel archivoActualizado) {
        if (id == null || archivoActualizado == null) {
            throw new IllegalArgumentException("El ID y los datos del archivo no pueden ser null");
        }
        Optional<ArchivoAdjuntoModel> archivoExistenteOpt = archivoAdjuntoRepository.findById(id);

        if (archivoExistenteOpt.isPresent()) {
            
            // Validar primero el objeto actualizado
            if (!esValido(archivoActualizado)) {
                 System.err.println("Error de validación: El Archivo Adjunto actualizado es inválido (FK).");
                 return null;
            }
            
            ArchivoAdjuntoModel archivoExistente = archivoExistenteOpt.get();
            
            // Aplicar los cambios
            archivoExistente.setReunion(archivoActualizado.getReunion());
            archivoExistente.setResena(archivoActualizado.getResena());
            archivoExistente.setTipo(archivoActualizado.getTipo());
            archivoExistente.setNombre(archivoActualizado.getNombre());
            archivoExistente.setUrl(archivoActualizado.getUrl());

            return archivoAdjuntoRepository.save(archivoExistente);
        } else {
            return null;
        }
    }

    @Override
    public void eliminarArchivo(Integer id) {

        if (!archivoAdjuntoRepository.existsById(id)) {
            throw new IllegalArgumentException("No existe un archivo adjunto con el ID: " + id);
        }
        archivoAdjuntoRepository.deleteById(id);
    }
}
