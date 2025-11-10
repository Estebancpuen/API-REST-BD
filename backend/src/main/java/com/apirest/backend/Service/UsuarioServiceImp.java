package com.apirest.backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.Model.UsuarioModel;
import com.apirest.backend.Repository.UsuarioRepository;

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
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser null");
        }
        if (usuario.getNombreCompleto() == null || usuario.getNombreCompleto().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre completo no puede ser null o vacío");
        }
        if (usuario.getCorreoElectronico() == null || usuario.getCorreoElectronico().trim().isEmpty()) {
            throw new IllegalArgumentException("El correo electrónico no puede ser null o vacío");
        }
        if (usuario.getRol() == null) {
            throw new IllegalArgumentException("El rol no puede ser null");
        }
        // Los campos edad, ocupacion y telefono pueden ser null según la BD
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioModel obtenerPorId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser null");
        }
        Optional<UsuarioModel> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null); 
    }

    @Override
    public void eliminarUsuario(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser null");
        }
        if (!usuarioRepository.existsById(id)) {
            throw new IllegalArgumentException("No existe un usuario con el ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }

    @Override 
    public UsuarioModel actualizarUsuario(Integer id, UsuarioModel usuarioActualizado) {
        if (id == null || usuarioActualizado == null) {
            throw new IllegalArgumentException("El ID y los datos del usuario no pueden ser null");
        }
        
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
