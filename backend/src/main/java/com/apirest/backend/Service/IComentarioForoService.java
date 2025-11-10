package com.apirest.backend.Service;

import java.util.List;

import com.apirest.backend.Model.ComentarioForoModel;

public interface IComentarioForoService {
    List<ComentarioForoModel> obtenerTodos();
    ComentarioForoModel guardarComentario(ComentarioForoModel comentario);
    ComentarioForoModel obtenerPorId(Integer id);
    ComentarioForoModel actualizarComentario(Integer id, ComentarioForoModel comentarioActualizado);
    void eliminarComentario(Integer id);
}
