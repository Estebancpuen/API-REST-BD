package com.apirest.backend.Service;

import com.apirest.backend.Model.ValoraModel;
import com.apirest.backend.Repository.ValoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ValoraServiceImp implements IValoraService {

    @Autowired
    private ValoraRepository valoraRepository;

    @Override
    public List<ValoraModel> obtenerTodos() {
        return valoraRepository.findAll();
    }

    @Override
    public ValoraModel guardarValoracion(ValoraModel valoracion) {
        if (valoracion == null) {
            throw new IllegalArgumentException("La valoración no puede ser null");
        }
        // DB: idUsuario, idResena, utilidad NOT NULL
        if (valoracion.getUsuario() == null || valoracion.getUsuario().getIdUsuario() == null) {
            throw new IllegalArgumentException("La valoración debe tener un usuario válido");
        }
        if (valoracion.getResena() == null || valoracion.getResena().getIdResena() == null) {
            throw new IllegalArgumentException("La valoración debe referenciar una reseña válida");
        }
        if (valoracion.getUtilidad() == null) {
            throw new IllegalArgumentException("El campo utilidad no puede ser null");
        }
        return valoraRepository.save(valoracion);
    }

    @Override
    public ValoraModel obtenerPorId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser null");
        }
        Optional<ValoraModel> valoracion = valoraRepository.findById(id);
        return valoracion.orElse(null);
    }

    @Override
    public ValoraModel actualizarValoracion(Integer id, ValoraModel valoracionActualizada) {
        if (id == null || valoracionActualizada == null) {
            throw new IllegalArgumentException("El ID y los datos de la valoración no pueden ser null");
        }
        Optional<ValoraModel> valoracionExistenteOpt = valoraRepository.findById(id);

        if (valoracionExistenteOpt.isPresent()) {
            ValoraModel valoracionExistente = valoracionExistenteOpt.get();
            
            // Aplicar los cambios (FKs y Utilidad)
            valoracionExistente.setUsuario(valoracionActualizada.getUsuario());
            valoracionExistente.setResena(valoracionActualizada.getResena());
            valoracionExistente.setUtilidad(valoracionActualizada.getUtilidad());

            return valoraRepository.save(valoracionExistente);
        } else {
            return null;
        }
    }

    @Override
    public void eliminarValoracion(Integer id) {
        valoraRepository.deleteById(id);
    }
}