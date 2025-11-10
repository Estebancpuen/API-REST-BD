package com.apirest.backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.Model.ForoModel;
import com.apirest.backend.Repository.ForoRepository;

@Service
public class ForoServiceImp implements IForoService {

    @Autowired
    private ForoRepository foroRepository;

    @Override
    public List<ForoModel> obtenerTodos() {
        return foroRepository.findAll();
    }

    @Override
    public ForoModel guardarForo(ForoModel foro) {
        if (foro == null) {
            throw new IllegalArgumentException("El foro no puede ser null");
        }
        // DB: idUsuario y fechaCreacion NOT NULL
        if (foro.getUsuario() == null || foro.getUsuario().getIdUsuario() == null) {
            throw new IllegalArgumentException("El foro debe tener un usuario válido");
        }
        if (foro.getFechaCreacion() == null) {
            throw new IllegalArgumentException("La fecha de creación del foro no puede ser null");
        }
        // categoria, descripcion y titulo pueden ser null según la BD
        return foroRepository.save(foro);
    }

    @Override
    public ForoModel obtenerPorId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser null");
        }
        Optional<ForoModel> foro = foroRepository.findById(id);
        return foro.orElse(null);
    }

    @Override
    public ForoModel actualizarForo(Integer id, ForoModel foroActualizado) {
        if (id == null || foroActualizado == null) {
            throw new IllegalArgumentException("El ID y los datos del foro no pueden ser null");
        }
        Optional<ForoModel> foroExistenteOpt = foroRepository.findById(id);

        if (foroExistenteOpt.isPresent()) {
            ForoModel foroExistente = foroExistenteOpt.get();
            
            foroExistente.setUsuario(foroActualizado.getUsuario());
            foroExistente.setFechaCreacion(foroActualizado.getFechaCreacion());
            foroExistente.setCategoria(foroActualizado.getCategoria());
            foroExistente.setDescripcion(foroActualizado.getDescripcion());
            foroExistente.setTitulo(foroActualizado.getTitulo());

            return foroRepository.save(foroExistente);
        } else {
            return null;
        }
    }

    @Override
    public void eliminarForo(Integer id) {
        foroRepository.deleteById(id);
    }
}
