package com.apirest.backend.Service;

import com.apirest.backend.Model.UsuarioModel;
import java.util.List;

public interface IUsuarioService {

    List<UsuarioModel> obtenerTodos();
    UsuarioModel guardarUsuario(UsuarioModel usuario);
    UsuarioModel obtenerPorId(Integer id);
    void eliminarUsuario(Integer id);
    UsuarioModel actualizarUsuario(Integer id, UsuarioModel usuarioActualizado); 
}
