package com.apirest.backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.Model.ReunionModel;
import com.apirest.backend.Repository.ReunionRepository;

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
        if (reunion == null) {
            throw new IllegalArgumentException("La reunión no puede ser null");
        }
        // DB: idLibro y fecha son NOT NULL
        if (reunion.getLibro() == null || reunion.getLibro().getIdLibro() == null) {
            throw new IllegalArgumentException("La reunión debe referenciar un libro válido");
        }
        if (reunion.getFecha() == null) {
            throw new IllegalArgumentException("La fecha de la reunión no puede ser null");
        }
        return reunionRepository.save(reunion);
    }

    @Override
    public ReunionModel obtenerPorId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser null");
        }
        Optional<ReunionModel> reunion = reunionRepository.findById(id);
        return reunion.orElse(null);
    }

    @Override
    public ReunionModel actualizarReunion(Integer id, ReunionModel reunionActualizada) {
        if (id == null || reunionActualizada == null) {
            throw new IllegalArgumentException("El ID y los datos de la reunión no pueden ser null");
        }
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
