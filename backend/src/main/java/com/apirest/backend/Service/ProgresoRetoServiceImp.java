package com.apirest.backend.Service;

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
        if (progreso == null) {
            throw new IllegalArgumentException("El progreso no puede ser null");
        }
        // DB: idInscripcion e idLibro son NOT NULL
        if (progreso.getInscripcion() == null || progreso.getInscripcion().getIdInscripcion() == null) {
            throw new IllegalArgumentException("El progreso debe referenciar una inscripción válida");
        }
        if (progreso.getLibro() == null || progreso.getLibro().getIdLibro() == null) {
            throw new IllegalArgumentException("El progreso debe referenciar un libro válido");
        }
        return progresoRetoRepository.save(progreso);
    }

    @Override
    public ProgresoRetoModel obtenerPorId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser null");
        }
        Optional<ProgresoRetoModel> progreso = progresoRetoRepository.findById(id);
        return progreso.orElse(null);
    }

    @Override
    public ProgresoRetoModel actualizarProgreso(Integer id, ProgresoRetoModel progresoActualizado) {
        if (id == null || progresoActualizado == null) {
            throw new IllegalArgumentException("El ID y los datos del progreso no pueden ser null");
        }
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