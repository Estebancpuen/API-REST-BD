package com.apirest.backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.Model.ComentarioForoModel;
import com.apirest.backend.Repository.ComentarioForoRepository;

@Service
public class ComentarioForoServiceImp implements IComentarioForoService {

    @Autowired
    private ComentarioForoRepository comentarioForoRepository;

    @Override
    public List<ComentarioForoModel> obtenerTodos() {
        return comentarioForoRepository.findAll();
    }

    @Override
    public ComentarioForoModel guardarComentario(ComentarioForoModel comentario) {
        if (comentario == null) {
            throw new IllegalArgumentException("El comentario no puede ser null");
        }
        // DB: idUsuario, idForo y contenido son NOT NULL. comentarioPadre puede ser NULL.
        if (comentario.getUsuario() == null || comentario.getUsuario().getIdUsuario() == null) {
            throw new IllegalArgumentException("El comentario debe tener un usuario válido");
        }
        if (comentario.getForo() == null || comentario.getForo().getIdForo() == null) {
            throw new IllegalArgumentException("El comentario debe referenciar un foro válido");
        }
        if (comentario.getContenido() == null || comentario.getContenido().trim().isEmpty()) {
            throw new IllegalArgumentException("El contenido del comentario no puede ser null o vacío");
        }
        return comentarioForoRepository.save(comentario);
    }

    @Override
    public ComentarioForoModel obtenerPorId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser null");
        }
        Optional<ComentarioForoModel> comentario = comentarioForoRepository.findById(id);
        return comentario.orElse(null);
    }

    @Override
    public ComentarioForoModel actualizarComentario(Integer id, ComentarioForoModel comentarioActualizado) {
        if (id == null || comentarioActualizado == null) {
            throw new IllegalArgumentException("El ID y los datos del comentario no pueden ser null");
        }
        Optional<ComentarioForoModel> comentarioExistenteOpt = comentarioForoRepository.findById(id);

        if (comentarioExistenteOpt.isPresent()) {
            ComentarioForoModel comentarioExistente = comentarioExistenteOpt.get();
            
            // Aplicar los cambios
            comentarioExistente.setUsuario(comentarioActualizado.getUsuario());
            comentarioExistente.setForo(comentarioActualizado.getForo());
            comentarioExistente.setComentarioPadre(comentarioActualizado.getComentarioPadre());
            comentarioExistente.setContenido(comentarioActualizado.getContenido());
            
            // La fecha de publicación no se toca.

            return comentarioForoRepository.save(comentarioExistente);
        } else {
            return null;
        }
    }

    @Override
    public void eliminarComentario(Integer id) {
        comentarioForoRepository.deleteById(id);
    }
}
