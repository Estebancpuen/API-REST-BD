package com.apirest.backend.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.Model.ProgresoRetoModel;
import com.apirest.backend.Repository.ProgresoRetoRepository;

@Service
public class ProgresoRetoServiceImp implements IProgresoRetoService {

    @Autowired
    private ProgresoRetoRepository progresoRetoRepository;

    @Override
    public List<ProgresoRetoModel> obtenerTodos() {
        return progresoRetoRepository.findAll();
    }

    @Override
public ProgresoRetoModel guardarProgreso(ProgresoRetoModel progreso) {

    // Extracción y validación de FKs
    if (progreso.getInscripcion() == null || progreso.getInscripcion().getIdInscripcion() == null) {
        throw new IllegalArgumentException("El progreso debe referenciar una inscripción válida");
    }
    if (progreso.getLibro() == null || progreso.getLibro().getIdLibro() == null) {
        throw new IllegalArgumentException("El progreso debe referenciar un libro válido");
    }
    
    progreso.setFechaActualizacion(new java.sql.Date(new Date().getTime()));
        if (progreso.getEstado() == null) {
        progreso.setEstado(ProgresoRetoModel.EstadoProgreso.no_iniciado);
    }

    return progresoRetoRepository.save(progreso);
}

    @Override
    public ProgresoRetoModel obtenerPorId(Integer id) {

        Optional<ProgresoRetoModel> progreso = progresoRetoRepository.findById(id);
        return progreso.orElse(null);
    }

    @Override
    public ProgresoRetoModel actualizarProgreso(Integer id, ProgresoRetoModel progresoActualizado) {

        Optional<ProgresoRetoModel> progresoExistenteOpt = progresoRetoRepository.findById(id);

        if (progresoExistenteOpt.isPresent()) {
            ProgresoRetoModel progresoExistente = progresoExistenteOpt.get();
            
            // Aplicar los cambios
            progresoExistente.setInscripcion(progresoActualizado.getInscripcion());
            progresoExistente.setLibro(progresoActualizado.getLibro());
            progresoExistente.setPorcentajeAvance(progresoActualizado.getPorcentajeAvance()); // La validación ocurre en el setter del modelo
            progresoExistente.setFechaActualizacion(progresoActualizado.getFechaActualizacion());
            progresoExistente.setEstado(progresoActualizado.getEstado());

            return progresoRetoRepository.save(progresoExistente);
        } else {
            return null;
        }
    }

    @Override
    public void eliminarProgreso(Integer id) {
        progresoRetoRepository.deleteById(id);
    }
}