package com.apirest.backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.Model.ComentarioResenaModel;
import com.apirest.backend.Repository.ComentarioResenaRepository;

@Service
public class ComentarioResenaServiceImp implements IComentarioResenaService {

    @Autowired
    private ComentarioResenaRepository comentarioResenaRepository;

    @Override
    public List<ComentarioResenaModel> obtenerTodos() {
        return comentarioResenaRepository.findAll();
    }

    @Override
    public ComentarioResenaModel guardarComentario(ComentarioResenaModel comentario) {
        if (comentario == null) {
            throw new IllegalArgumentException("El comentario no puede ser null");
        }
        // DB: idUsuario, idResena y contenido son NOT NULL
        if (comentario.getUsuario() == null || comentario.getUsuario().getIdUsuario() == null) {
            throw new IllegalArgumentException("El comentario debe tener un usuario válido");
        }
        if (comentario.getResena() == null || comentario.getResena().getIdResena() == null) {
            throw new IllegalArgumentException("El comentario debe referenciar una reseña válida");
        }
        if (comentario.getContenido() == null || comentario.getContenido().trim().isEmpty()) {
            throw new IllegalArgumentException("El contenido del comentario no puede ser null o vacío");
        }
        return comentarioResenaRepository.save(comentario);
    }

    @Override
    public ComentarioResenaModel obtenerPorId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser null");
        }
        Optional<ComentarioResenaModel> comentario = comentarioResenaRepository.findById(id);
        return comentario.orElse(null);
    }

    @Override
    public ComentarioResenaModel actualizarComentario(Integer id, ComentarioResenaModel comentarioActualizado) {
        if (id == null || comentarioActualizado == null) {
            throw new IllegalArgumentException("El ID y los datos del comentario no pueden ser null");
        }
        Optional<ComentarioResenaModel> comentarioExistenteOpt = comentarioResenaRepository.findById(id);

        if (comentarioExistenteOpt.isPresent()) {
            ComentarioResenaModel comentarioExistente = comentarioExistenteOpt.get();
            
            // Aplicar los cambios
            comentarioExistente.setUsuario(comentarioActualizado.getUsuario());
            comentarioExistente.setResena(comentarioActualizado.getResena());
            comentarioExistente.setContenido(comentarioActualizado.getContenido());
            // No se actualiza la fecha de publicación automáticamente

            return comentarioResenaRepository.save(comentarioExistente);
        } else {
            return null;
        }
    }

    @Override
    public void eliminarComentario(Integer id) {
        comentarioResenaRepository.deleteById(id);
    }
}
