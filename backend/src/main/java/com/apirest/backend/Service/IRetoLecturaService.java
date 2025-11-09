package com.apirest.backend.Service;

import com.apirest.backend.Model.RetoLecturaModel;
import java.util.List;

public interface IRetoLecturaService {
    List<RetoLecturaModel> obtenerTodos();
    RetoLecturaModel guardarReto(RetoLecturaModel reto);
    RetoLecturaModel obtenerPorId(Integer id);
    RetoLecturaModel actualizarReto(Integer id, RetoLecturaModel retoActualizado);
    void eliminarReto(Integer id);
}
