package com.apirest.backend.Service;

import java.util.List;

import com.apirest.backend.Model.VotacionModel;

public interface IVotacionService {
    List<VotacionModel> obtenerTodos();
    VotacionModel guardarVotacion(VotacionModel votacion);
    VotacionModel obtenerPorId(Integer id);
    VotacionModel actualizarVotacion(Integer id, VotacionModel votacionActualizada);
    void eliminarVotacion(Integer id);
}
