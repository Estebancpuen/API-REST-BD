package com.apirest.backend.Service;

import com.apirest.backend.Model.ForoModel;
import java.util.List;

public interface IForoService {
    List<ForoModel> obtenerTodos();
    ForoModel guardarForo(ForoModel foro);
    ForoModel obtenerPorId(Integer id);
    ForoModel actualizarForo(Integer id, ForoModel foroActualizado);
    void eliminarForo(Integer id);
}
