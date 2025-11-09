package com.apirest.backend.Service;

import com.apirest.backend.Model.ForoModel;
import com.apirest.backend.Repository.ForoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
        return foroRepository.save(foro);
    }

    @Override
    public ForoModel obtenerPorId(Integer id) {
        Optional<ForoModel> foro = foroRepository.findById(id);
        return foro.orElse(null);
    }

    @Override
    public ForoModel actualizarForo(Integer id, ForoModel foroActualizado) {
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
