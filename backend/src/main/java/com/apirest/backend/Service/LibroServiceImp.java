package com.apirest.backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.Model.LibroModel;
import com.apirest.backend.Repository.LibroRepository;

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
        if (libro == null) {
            throw new IllegalArgumentException("El libro no puede ser null");
        }
        if (libro.getTitulo() == null || libro.getTitulo().trim().isEmpty()) {
            throw new IllegalArgumentException("El título del libro no puede ser null o vacío");
        }
        // Los demás campos pueden ser null según la BD: autor, genero, anoPublicacion, sinopsis, portada
        return libroRepository.save(libro);
    }

    @Override
    public LibroModel obtenerPorId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser null");
        }
        Optional<LibroModel> libro = libroRepository.findById(id);
        return libro.orElse(null);
    }

    @Override
    public LibroModel actualizarLibro(Integer id, LibroModel libroActualizado) {
        if (id == null || libroActualizado == null) {
            throw new IllegalArgumentException("El ID y los datos del libro no pueden ser null");
        }
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