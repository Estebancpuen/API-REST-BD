package com.apirest.backend.Service;

import com.apirest.backend.Model.ComentarioResenaModel;
import java.util.List;

public interface IComentarioResenaService {
    List<ComentarioResenaModel> obtenerTodos();
    ComentarioResenaModel guardarComentario(ComentarioResenaModel comentario);
    ComentarioResenaModel obtenerPorId(Integer id);
    ComentarioResenaModel actualizarComentario(Integer id, ComentarioResenaModel comentarioActualizado);
    void eliminarComentario(Integer id);
}
