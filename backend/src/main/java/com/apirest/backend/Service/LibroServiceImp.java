package com.apirest.backend.Service;

import com.apirest.backend.Model.LibroModel;
import com.apirest.backend.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImp implements ILibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public List<LibroModel> obtenerTodos() {
        return libroRepository.findAll();
    }

    @Override
    public LibroModel guardarLibro(LibroModel libro) {
        return libroRepository.save(libro);
    }

    @Override
    public LibroModel obtenerPorId(Integer id) {
        Optional<LibroModel> libro = libroRepository.findById(id);
        return libro.orElse(null);
    }

    @Override
    public LibroModel actualizarLibro(Integer id, LibroModel libroActualizado) {
        Optional<LibroModel> libroExistenteOpt = libroRepository.findById(id);

        if (libroExistenteOpt.isPresent()) {
            LibroModel libroExistente = libroExistenteOpt.get();
            
            // Aplicar los cambios
            libroExistente.setTitulo(libroActualizado.getTitulo());
            libroExistente.setAutor(libroActualizado.getAutor());
            libroExistente.setGenero(libroActualizado.getGenero());
            libroExistente.setAnoPublicacion(libroActualizado.getAnoPublicacion());
            libroExistente.setSinopsis(libroActualizado.getSinopsis());
            libroExistente.setPortada(libroActualizado.getPortada());
            libroExistente.setEstadoLectura(libroActualizado.getEstadoLectura());
            libroExistente.setFechaSeleccion(libroActualizado.getFechaSeleccion());

            return libroRepository.save(libroExistente);
        } else {
            return null;
        }
    }

    @Override
    public void eliminarLibro(Integer id) {
        libroRepository.deleteById(id);
    }
}