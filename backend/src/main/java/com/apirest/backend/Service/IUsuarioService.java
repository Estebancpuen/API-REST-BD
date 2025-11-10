package com.apirest.backend.Service;

import java.util.List;

import com.apirest.backend.Model.UsuarioModel;

public interface IUsuarioService {

    List<UsuarioModel> obtenerTodos();
    UsuarioModel guardarUsuario(UsuarioModel usuario);
    UsuarioModel obtenerPorId(Integer id);
    void eliminarUsuario(Integer id);
    UsuarioModel actualizarUsuario(Integer id, UsuarioModel usuarioActualizado); 
}
