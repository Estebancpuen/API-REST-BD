package com.apirest.backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.Model.ResenaModel;
import com.apirest.backend.Repository.ResenaRepository;

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
        // DB: idUsuario, idLibro y fecha y calificacion son NOT NULL
        if (resena.getUsuario() == null || resena.getUsuario().getIdUsuario() == null) {
            throw new IllegalArgumentException("La reseña debe tener un usuario válido");
        }
        if (resena.getLibro() == null || resena.getLibro().getIdLibro() == null) {
            throw new IllegalArgumentException("La reseña debe referenciar un libro válido");
        }
        if (resena.getCalificacion() == null || resena.getCalificacion() < 1 || resena.getCalificacion() > 5) {
            throw new IllegalArgumentException("La calificación debe estar entre 1 y 5");
        }
        // opinion puede ser null
        return resenaRepository.save(resena);
    }

    @Override
    public ResenaModel obtenerPorId(Integer id) {

        Optional<ResenaModel> resena = resenaRepository.findById(id);
        return resena.orElse(null);
    }

    @Override
    public ResenaModel actualizarResena(Integer id, ResenaModel resenaActualizada) {
        if (id == null || resenaActualizada == null) {
            throw new IllegalArgumentException("El ID y los datos de la reseña no pueden ser null");
        }
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