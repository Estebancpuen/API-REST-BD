package com.apirest.backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apirest.backend.Model.InscripcionModel;
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
        if (inscripcion == null) {
            throw new IllegalArgumentException("La inscripción no puede ser null");
        }
        // DB: idUsuario e idReto son NOT NULL
        if (inscripcion.getUsuario() == null || inscripcion.getUsuario().getIdUsuario() == null) {
            throw new IllegalArgumentException("La inscripción debe tener un usuario válido");
        }
        if (inscripcion.getReto() == null || inscripcion.getReto().getIdReto() == null) {
            throw new IllegalArgumentException("La inscripción debe referenciar un reto válido");
        }
        return inscripcionRepository.save(inscripcion);
    }

    @Override
    public InscripcionModel obtenerPorId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser null");
        }
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
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser null");
        }
        if (!inscripcionRepository.existsById(id)) {
            throw new IllegalArgumentException("No existe una inscripción con el ID: " + id);
        }
        inscripcionRepository.deleteById(id);
    }
}
