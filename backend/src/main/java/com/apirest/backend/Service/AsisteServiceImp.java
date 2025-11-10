package com.apirest.backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.Model.AsisteModel;
import com.apirest.backend.Repository.AsisteRepository;

@Service
public class AsisteServiceImp implements IAsisteService {

    @Autowired
    private AsisteRepository asisteRepository;

    @Override
    public List<AsisteModel> obtenerTodos() {
        return asisteRepository.findAll();
    }

    @Override
    public AsisteModel guardarAsistencia(AsisteModel asistencia) {
        if (asistencia == null) {
            throw new IllegalArgumentException("La asistencia no puede ser null");
        }
        // DB: idUsuario e idReunion son NOT NULL
        if (asistencia.getUsuario() == null || asistencia.getUsuario().getIdUsuario() == null) {
            throw new IllegalArgumentException("La asistencia debe tener un usuario válido");
        }
        if (asistencia.getReunion() == null || asistencia.getReunion().getIdReunion() == null) {
            throw new IllegalArgumentException("La asistencia debe referenciar una reunión válida");
        }
        return asisteRepository.save(asistencia);
    }

    @Override
    public AsisteModel obtenerPorId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser null");
        }
        Optional<AsisteModel> asistencia = asisteRepository.findById(id);
        return asistencia.orElse(null);
    }

    @Override
    public AsisteModel actualizarAsistencia(Integer id, AsisteModel asistenciaActualizada) {
        if (id == null || asistenciaActualizada == null) {
            throw new IllegalArgumentException("El ID y los datos de asistencia no pueden ser null");
        }
        Optional<AsisteModel> asistenciaExistenteOpt = asisteRepository.findById(id);

        if (asistenciaExistenteOpt.isPresent()) {
            AsisteModel asistenciaExistente = asistenciaExistenteOpt.get();
            
            // Aplicar los cambios (solo las FKs)
            asistenciaExistente.setUsuario(asistenciaActualizada.getUsuario());
            asistenciaExistente.setReunion(asistenciaActualizada.getReunion());

            return asisteRepository.save(asistenciaExistente);
        } else {
            return null;
        }
    }

    @Override
    public void eliminarAsistencia(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser null");
        }
        if (!asisteRepository.existsById(id)) {
            throw new IllegalArgumentException("No existe una asistencia con el ID: " + id);
        }
        asisteRepository.deleteById(id);
    }
}
