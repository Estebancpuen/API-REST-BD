package com.apirest.backend.Service;

import com.apirest.backend.Model.IncluyeModel;
import com.apirest.backend.Repository.IncluyeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class IncluyeServiceImp implements IIncluyeService {

    @Autowired
    private IncluyeRepository incluyeRepository;

    @Override
    public List<IncluyeModel> obtenerTodos() {
        return incluyeRepository.findAll();
    }

    @Override
    public IncluyeModel guardarInclusion(IncluyeModel inclusion) {
        return incluyeRepository.save(inclusion);
    }

    @Override
    public IncluyeModel obtenerPorId(Integer id) {
        Optional<IncluyeModel> inclusion = incluyeRepository.findById(id);
        return inclusion.orElse(null);
    }

    @Override
    public IncluyeModel actualizarInclusion(Integer id, IncluyeModel inclusionActualizada) {
        Optional<IncluyeModel> inclusionExistenteOpt = incluyeRepository.findById(id);

        if (inclusionExistenteOpt.isPresent()) {
            IncluyeModel inclusionExistente = inclusionExistenteOpt.get();
            
            // Aplicar los cambios (solo las FKs)
            inclusionExistente.setLibro(inclusionActualizada.getLibro());
            inclusionExistente.setReto(inclusionActualizada.getReto());

            return incluyeRepository.save(inclusionExistente);
        } else {
            return null;
        }
    }

    @Override
    public void eliminarInclusion(Integer id) {
        incluyeRepository.deleteById(id);
    }
}
