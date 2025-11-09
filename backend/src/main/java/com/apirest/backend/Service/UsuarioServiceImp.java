package com.apirest.backend.Service;

import com.apirest.backend.Model.UsuarioModel;
import com.apirest.backend.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImp implements IUsuarioService { 

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioModel> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public UsuarioModel guardarUsuario(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioModel obtenerPorId(Integer id) {
        
        Optional<UsuarioModel> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null); 
    }

    @Override
    public void eliminarUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }

    @Override 
    public UsuarioModel actualizarUsuario(Integer id, UsuarioModel usuarioActualizado) {
        
        Optional<UsuarioModel> usuarioExistenteOpt = usuarioRepository.findById(id);

        if (usuarioExistenteOpt.isPresent()) {
            UsuarioModel usuarioExistente = usuarioExistenteOpt.get();
            
            usuarioExistente.setNombreCompleto(usuarioActualizado.getNombreCompleto());
            usuarioExistente.setEdad(usuarioActualizado.getEdad());
            usuarioExistente.setOcupacion(usuarioActualizado.getOcupacion());
            usuarioExistente.setCorreoElectronico(usuarioActualizado.getCorreoElectronico());
            usuarioExistente.setTelefono(usuarioActualizado.getTelefono());
            usuarioExistente.setRol(usuarioActualizado.getRol());

            
            return usuarioRepository.save(usuarioExistente);
        } else {
            
            return null; 
        }
    }
}
