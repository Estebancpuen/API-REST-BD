package com.apirest.backend.Service;

import com.apirest.backend.Model.PropuestaLibroModel;
import com.apirest.backend.Repository.PropuestaLibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PropuestaLibroServiceImp implements IPropuestaLibroService {

    @Autowired
    private PropuestaLibroRepository propuestaLibroRepository;

    @Override
    public List<PropuestaLibroModel> obtenerTodos() {
        return propuestaLibroRepository.findAll();
    }

    @Override
    public PropuestaLibroModel guardarPropuesta(PropuestaLibroModel propuesta) {
        return propuestaLibroRepository.save(propuesta);
    }

    @Override
    public PropuestaLibroModel obtenerPorId(Integer id) {
        Optional<PropuestaLibroModel> propuesta = propuestaLibroRepository.findById(id);
        return propuesta.orElse(null);
    }

    @Override
    public PropuestaLibroModel actualizarPropuesta(Integer id, PropuestaLibroModel propuestaActualizada) {
        Optional<PropuestaLibroModel> propuestaExistenteOpt = propuestaLibroRepository.findById(id);

        if (propuestaExistenteOpt.isPresent()) {
            PropuestaLibroModel propuestaExistente = propuestaExistenteOpt.get();
            
            // Aplicar los cambios. Las FK deben ser objetos completos.
            propuestaExistente.setUsuario(propuestaActualizada.getUsuario());
            propuestaExistente.setLibro(propuestaActualizada.getLibro());
            propuestaExistente.setFechaPropuesta(propuestaActualizada.getFechaPropuesta());
            propuestaExistente.setEstado(propuestaActualizada.getEstado());
            propuestaExistente.setFechaDecision(propuestaActualizada.getFechaDecision());

            return propuestaLibroRepository.save(propuestaExistente);
        } else {
            return null;
        }
    }

    @Override
    public void eliminarPropuesta(Integer id) {
        propuestaLibroRepository.deleteById(id);
    }
}