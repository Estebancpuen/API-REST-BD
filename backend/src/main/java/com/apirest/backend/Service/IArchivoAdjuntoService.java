package com.apirest.backend.Service;

import com.apirest.backend.Model.ArchivoAdjuntoModel;
import java.util.List;

public interface IArchivoAdjuntoService {
    List<ArchivoAdjuntoModel> obtenerTodos();
    ArchivoAdjuntoModel guardarArchivo(ArchivoAdjuntoModel archivo);
    ArchivoAdjuntoModel obtenerPorId(Integer id);
    ArchivoAdjuntoModel actualizarArchivo(Integer id, ArchivoAdjuntoModel archivoActualizado);
    void eliminarArchivo(Integer id);
}
