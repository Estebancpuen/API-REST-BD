package com.apirest.backend.Service;

import com.apirest.backend.Model.VotacionModel;
import java.util.List;

public interface IVotacionService {
    List<VotacionModel> obtenerTodos();
    VotacionModel guardarVotacion(VotacionModel votacion);
    VotacionModel obtenerPorId(Integer id);
    VotacionModel actualizarVotacion(Integer id, VotacionModel votacionActualizada);
    void eliminarVotacion(Integer id);
}
