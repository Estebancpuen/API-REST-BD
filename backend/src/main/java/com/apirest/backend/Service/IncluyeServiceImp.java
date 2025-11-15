package com.apirest.backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.Model.IncluyeModel;
import com.apirest.backend.Repository.IncluyeRepository;

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
        // DB: idLibro e idReto son NOT NULL
        if (inclusion.getLibro() == null || inclusion.getLibro().getIdLibro() == null) {
            throw new IllegalArgumentException("La inclusión debe referenciar un libro válido");
        }
        if (inclusion.getReto() == null || inclusion.getReto().getIdReto() == null) {
            throw new IllegalArgumentException("La inclusión debe referenciar un reto válido");
        }
        return incluyeRepository.save(inclusion);
    }

    @Override
    public IncluyeModel obtenerPorId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser null");
        }
        Optional<IncluyeModel> inclusion = incluyeRepository.findById(id);
        return inclusion.orElse(null);
    }

    @Override
    public IncluyeModel actualizarInclusion(Integer id, IncluyeModel inclusionActualizada) {
        if (id == null || inclusionActualizada == null) {
            throw new IllegalArgumentException("El ID y los datos de la inclusión no pueden ser null");
        }
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
