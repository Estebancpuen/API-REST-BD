package com.apirest.backend.Service;

import com.apirest.backend.Model.InscripcionModel;
import com.apirest.backend.Repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
        return inscripcionRepository.save(inscripcion);
    }

    @Override
    public InscripcionModel obtenerPorId(Integer id) {
        Optional<InscripcionModel> inscripcion = inscripcionRepository.findById(id);
        return inscripcion.orElse(null);
    }

    @Override
    public InscripcionModel actualizarInscripcion(Integer id, InscripcionModel inscripcionActualizada) {
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
        inscripcionRepository.deleteById(id);
    }
}
