package com.apirest.backend.Service;

import com.apirest.backend.Model.ComentarioForoModel;
import com.apirest.backend.Repository.ComentarioForoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
        return comentarioForoRepository.save(comentario);
    }

    @Override
    public ComentarioForoModel obtenerPorId(Integer id) {
        Optional<ComentarioForoModel> comentario = comentarioForoRepository.findById(id);
        return comentario.orElse(null);
    }

    @Override
    public ComentarioForoModel actualizarComentario(Integer id, ComentarioForoModel comentarioActualizado) {
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
