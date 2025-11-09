package com.apirest.backend.Service;

import com.apirest.backend.Model.ReunionModel;
import com.apirest.backend.Repository.ReunionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReunionServiceImp implements IReunionService {

    @Autowired
    private ReunionRepository reunionRepository;

    @Override
    public List<ReunionModel> obtenerTodos() {
        return reunionRepository.findAll();
    }

    @Override
    public ReunionModel guardarReunion(ReunionModel reunion) {
        return reunionRepository.save(reunion);
    }

    @Override
    public ReunionModel obtenerPorId(Integer id) {
        Optional<ReunionModel> reunion = reunionRepository.findById(id);
        return reunion.orElse(null);
    }

    @Override
    public ReunionModel actualizarReunion(Integer id, ReunionModel reunionActualizada) {
        Optional<ReunionModel> reunionExistenteOpt = reunionRepository.findById(id);

        if (reunionExistenteOpt.isPresent()) {
            ReunionModel reunionExistente = reunionExistenteOpt.get();
            
            reunionExistente.setLibro(reunionActualizada.getLibro()); 
            reunionExistente.setFecha(reunionActualizada.getFecha());
            reunionExistente.setHora(reunionActualizada.getHora());
            reunionExistente.setModalidad(reunionActualizada.getModalidad());
            reunionExistente.setLugarOEnlace(reunionActualizada.getLugarOEnlace());

            return reunionRepository.save(reunionExistente);
        } else {
            return null;
        }
    }

    @Override
    public void eliminarReunion(Integer id) {
        reunionRepository.deleteById(id);
    }
}
