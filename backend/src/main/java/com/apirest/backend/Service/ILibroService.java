package com.apirest.backend.Service;

import java.util.List;

import com.apirest.backend.Model.LibroModel;

public interface ILibroService {
    List<LibroModel> obtenerTodos();
    LibroModel guardarLibro(LibroModel libro);
    LibroModel obtenerPorId(Integer id);
    LibroModel actualizarLibro(Integer id, LibroModel libroActualizado);
    void eliminarLibro(Integer id);
}
