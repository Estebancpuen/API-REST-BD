package com.apirest.backend.Service;

import java.util.List;

import com.apirest.backend.Model.ArchivoAdjuntoModel;

public interface IArchivoAdjuntoService {
    List<ArchivoAdjuntoModel> obtenerTodos();
    ArchivoAdjuntoModel guardarArchivo(ArchivoAdjuntoModel archivo);
    ArchivoAdjuntoModel obtenerPorId(Integer id);
    ArchivoAdjuntoModel actualizarArchivo(Integer id, ArchivoAdjuntoModel archivoActualizado);
    void eliminarArchivo(Integer id);
}
