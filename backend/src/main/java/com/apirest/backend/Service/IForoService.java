package com.apirest.backend.Service;

import java.util.List;

import com.apirest.backend.Model.ForoModel;

public interface IForoService {
    List<ForoModel> obtenerTodos();
    ForoModel guardarForo(ForoModel foro);
    ForoModel obtenerPorId(Integer id);
    ForoModel actualizarForo(Integer id, ForoModel foroActualizado);
    void eliminarForo(Integer id);
}
