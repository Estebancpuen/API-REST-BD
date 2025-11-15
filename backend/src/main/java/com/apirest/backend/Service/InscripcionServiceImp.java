package com.apirest.backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.Model.InscripcionModel;
import com.apirest.backend.Model.InscripcionModel.EstadoInscripcion;
import com.apirest.backend.Repository.InscripcionRepository;


@Service
public class InscripcionServiceImp implements IInscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Override
    public List<InscripcionModel> obtenerTodos() {
        return inscripcionRepository.findAll();
    }

    @Override
public InscripcionModel guardarInscripcion(InscripcionModel inscripcion) {

    Integer idUsuario = inscripcion.getUsuario() != null ? inscripcion.getUsuario().getIdUsuario() : null;
    Integer idReto = inscripcion.getReto() != null ? inscripcion.getReto().getIdReto() : null;
    if (idUsuario == null) {
        throw new IllegalArgumentException("La inscripción debe tener un usuario válido");
    }
    if (idReto == null) {
        throw new IllegalArgumentException("La inscripción debe referenciar un reto válido");
    }

    if (inscripcionRepository.existsByUsuarioIdUsuarioAndRetoIdReto(idUsuario, idReto)) {
        throw new IllegalArgumentException("Error de Duplicidad: El usuario ya está inscrito a este reto de lectura.");
    }
    return inscripcionRepository.save(inscripcion);
}

    @Override
    public InscripcionModel obtenerPorId(Integer id) {

        Optional<InscripcionModel> inscripcion = inscripcionRepository.findById(id);
        return inscripcion.orElse(null);
    }

    @Override
    public InscripcionModel actualizarInscripcion(Integer id, InscripcionModel inscripcionActualizada) {
        if (id == null || inscripcionActualizada == null) {
            throw new IllegalArgumentException("El ID y los datos de la inscripción no pueden ser null");
        }
        Optional<InscripcionModel> inscripcionExistenteOpt = inscripcionRepository.findById(id);

        if (inscripcionExistenteOpt.isPresent()) {
            InscripcionModel inscripcionExistente = inscripcionExistenteOpt.get();
            
            // Aplicar los cambios
            inscripcionExistente.setUsuario(inscripcionActualizada.getUsuario());
            inscripcionExistente.setReto(inscripcionActualizada.getReto());
            inscripcionExistente.setFecha(inscripcionActualizada.getFecha());
            inscripcionExistente.setEstadoInscripcion(inscripcionActualizada.getEstadoInscripcion());

            return inscripcionRepository.save(inscripcionExistente);
        } else {
            return null;
        }
    }

@Override
public void eliminarInscripcion(Integer id) {
    
    InscripcionModel inscripcion = inscripcionRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Inscripción no encontrada con ID: " + id));
    inscripcion.setEstadoInscripcion(EstadoInscripcion.cancelada); 
    inscripcionRepository.save(inscripcion);
}
}
