package com.apirest.backend.Service;

import com.apirest.backend.Model.ProgresoRetoModel;
import com.apirest.backend.Repository.ProgresoRetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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