package com.apirest.backend.Service;

import com.apirest.backend.Model.ResenaModel;
import com.apirest.backend.Repository.ResenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ResenaServiceImp implements IResenaService {

    @Autowired
    private ResenaRepository resenaRepository;

    @Override
    public List<ResenaModel> obtenerTodos() {
        return resenaRepository.findAll();
    }

    @Override
    public ResenaModel guardarResena(ResenaModel resena) {
        // Validación básica de la calificación antes de guardar (si no se usa un Trigger o constraints en la DB)
        if (resena.getCalificacion() == null || resena.getCalificacion() < 1 || resena.getCalificacion() > 5) {
             // En un proyecto real, lanzarías una excepción aquí.
             System.err.println("Error: Calificación debe estar entre 1 y 5.");
             return null;
        }
        return resenaRepository.save(resena);
    }

    @Override
    public ResenaModel obtenerPorId(Integer id) {
        Optional<ResenaModel> resena = resenaRepository.findById(id);
        return resena.orElse(null);
    }

    @Override
    public ResenaModel actualizarResena(Integer id, ResenaModel resenaActualizada) {
        Optional<ResenaModel> resenaExistenteOpt = resenaRepository.findById(id);

        if (resenaExistenteOpt.isPresent()) {
            ResenaModel resenaExistente = resenaExistenteOpt.get();
            
            // Aplicar los cambios
            resenaExistente.setUsuario(resenaActualizada.getUsuario());
            resenaExistente.setLibro(resenaActualizada.getLibro());
            resenaExistente.setFecha(resenaActualizada.getFecha());
            resenaExistente.setOpinion(resenaActualizada.getOpinion());
            
            // Re-validar la calificación al actualizar
            if (resenaActualizada.getCalificacion() != null && resenaActualizada.getCalificacion() >= 1 && resenaActualizada.getCalificacion() <= 5) {
                resenaExistente.setCalificacion(resenaActualizada.getCalificacion());
            } else {
                // Manejo de error o mantener la calificación antigua
                System.err.println("Error: Calificación de actualización inválida.");
            }
            
            // Nota: created_at NO debe ser actualizado manualmente.

            return resenaRepository.save(resenaExistente);
        } else {
            return null;
        }
    }

    @Override
    public void eliminarResena(Integer id) {
        resenaRepository.deleteById(id);
    }
}