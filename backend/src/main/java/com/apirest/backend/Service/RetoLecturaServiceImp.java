package com.apirest.backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.Model.RetoLecturaModel;
import com.apirest.backend.Repository.RetoLecturaRepository;

@Service
public class RetoLecturaServiceImp implements IRetoLecturaService {

    @Autowired
    private RetoLecturaRepository retoLecturaRepository;

    @Override
    public List<RetoLecturaModel> obtenerTodos() {
        return retoLecturaRepository.findAll();
    }

    @Override
    public RetoLecturaModel guardarReto(RetoLecturaModel reto) {
        if (reto == null) {
            throw new IllegalArgumentException("El reto no puede ser null");
        }
        if (reto.getTitulo() == null || reto.getTitulo().trim().isEmpty()) {
            throw new IllegalArgumentException("El título del reto no puede ser null o vacío");
        }
        return retoLecturaRepository.save(reto);
    }

    @Override
    public RetoLecturaModel obtenerPorId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser null");
        }
        Optional<RetoLecturaModel> reto = retoLecturaRepository.findById(id);
        return reto.orElse(null);
    }

    @Override
    public RetoLecturaModel actualizarReto(Integer id, RetoLecturaModel retoActualizado) {
        if (id == null || retoActualizado == null) {
            throw new IllegalArgumentException("El ID y los datos del reto no pueden ser null");
        }
        Optional<RetoLecturaModel> retoExistenteOpt = retoLecturaRepository.findById(id);

        if (retoExistenteOpt.isPresent()) {
            RetoLecturaModel retoExistente = retoExistenteOpt.get();
            
            // Aplicar los cambios
            retoExistente.setTitulo(retoActualizado.getTitulo());
            retoExistente.setDescripcion(retoActualizado.getDescripcion());
            retoExistente.setFechaInicio(retoActualizado.getFechaInicio());
            retoExistente.setFechaFin(retoActualizado.getFechaFin());

            return retoLecturaRepository.save(retoExistente);
        } else {
            return null;
        }
    }

    @Override
    public void eliminarReto(Integer id) {
        retoLecturaRepository.deleteById(id);
    }
}
