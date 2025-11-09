package com.apirest.backend.Service;

import com.apirest.backend.Model.LibroModel;
import java.util.List;

public interface ILibroService {
    List<LibroModel> obtenerTodos();
    LibroModel guardarLibro(LibroModel libro);
    LibroModel obtenerPorId(Integer id);
    LibroModel actualizarLibro(Integer id, LibroModel libroActualizado);
    void eliminarLibro(Integer id);
}
