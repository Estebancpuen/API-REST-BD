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
        return valoraRepository.save(valoracion);
    }

    @Override
    public ValoraModel obtenerPorId(Integer id) {
        Optional<ValoraModel> valoracion = valoraRepository.findById(id);
        return valoracion.orElse(null);
    }

    @Override
    public ValoraModel actualizarValoracion(Integer id, ValoraModel valoracionActualizada) {
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