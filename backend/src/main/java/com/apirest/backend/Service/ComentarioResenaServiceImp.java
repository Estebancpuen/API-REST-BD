package com.apirest.backend.Service;

import com.apirest.backend.Model.ComentarioResenaModel;
import com.apirest.backend.Repository.ComentarioResenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
        return comentarioResenaRepository.save(comentario);
    }

    @Override
    public ComentarioResenaModel obtenerPorId(Integer id) {
        Optional<ComentarioResenaModel> comentario = comentarioResenaRepository.findById(id);
        return comentario.orElse(null);
    }

    @Override
    public ComentarioResenaModel actualizarComentario(Integer id, ComentarioResenaModel comentarioActualizado) {
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
