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
        return retoLecturaRepository.save(reto);
    }

    @Override
    public RetoLecturaModel obtenerPorId(Integer id) {
        Optional<RetoLecturaModel> reto = retoLecturaRepository.findById(id);
        return reto.orElse(null);
    }

    @Override
    public RetoLecturaModel actualizarReto(Integer id, RetoLecturaModel retoActualizado) {
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

        // Consultar cuántos inscritos hay para ese reto
        int inscritos = retoLecturaRepository.contarInscritosPorReto(id);

        if (inscritos > 0) {
            // Si tiene inscritos, no se puede eliminar
            throw new IllegalStateException("No se puede eliminar el reto porque tiene inscritos.");
        }

        // Si no tiene inscritos, se elimina normalmente
        retoLecturaRepository.deleteById(id);
    }
}
