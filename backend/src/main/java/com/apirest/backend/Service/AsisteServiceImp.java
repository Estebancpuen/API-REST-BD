package com.apirest.backend.Service;

import com.apirest.backend.Model.AsisteModel;
import com.apirest.backend.Repository.AsisteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
        return asisteRepository.save(asistencia);
    }

    @Override
    public AsisteModel obtenerPorId(Integer id) {
        Optional<AsisteModel> asistencia = asisteRepository.findById(id);
        return asistencia.orElse(null);
    }

    @Override
    public AsisteModel actualizarAsistencia(Integer id, AsisteModel asistenciaActualizada) {
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
        asisteRepository.deleteById(id);
    }
}
