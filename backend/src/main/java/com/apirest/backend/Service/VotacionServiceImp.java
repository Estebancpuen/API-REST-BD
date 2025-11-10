package com.apirest.backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.Model.VotacionModel;
import com.apirest.backend.Repository.VotacionRepository;

@Service
public class VotacionServiceImp implements IVotacionService {

    @Autowired
    private VotacionRepository votacionRepository;

    @Override
    public List<VotacionModel> obtenerTodos() {
        return votacionRepository.findAll();
    }

    @Override
    public VotacionModel guardarVotacion(VotacionModel votacion) {
        if (votacion == null) {
            throw new IllegalArgumentException("La votación no puede ser null");
        }
        // DB: idUsuario, idPropuesta y voto son NOT NULL
        if (votacion.getUsuario() == null || votacion.getUsuario().getIdUsuario() == null) {
            throw new IllegalArgumentException("La votación debe tener un usuario válido");
        }
        if (votacion.getPropuesta() == null || votacion.getPropuesta().getIdPropuesta() == null) {
            throw new IllegalArgumentException("La votación debe referenciar una propuesta válida");
        }
        if (votacion.getVoto() == null) {
            throw new IllegalArgumentException("El campo voto no puede ser null");
        }
        return votacionRepository.save(votacion);
    }

    @Override
    public VotacionModel obtenerPorId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser null");
        }
        Optional<VotacionModel> votacion = votacionRepository.findById(id);
        return votacion.orElse(null);
    }

    @Override
    public VotacionModel actualizarVotacion(Integer id, VotacionModel votacionActualizada) {
        if (id == null || votacionActualizada == null) {
            throw new IllegalArgumentException("El ID y los datos de la votación no pueden ser null");
        }
        Optional<VotacionModel> votacionExistenteOpt = votacionRepository.findById(id);

        if (votacionExistenteOpt.isPresent()) {
            VotacionModel votacionExistente = votacionExistenteOpt.get();
            
            // Aplicar los cambios
            votacionExistente.setUsuario(votacionActualizada.getUsuario());
            votacionExistente.setPropuesta(votacionActualizada.getPropuesta());
            votacionExistente.setFechaVoto(votacionActualizada.getFechaVoto());
            votacionExistente.setVoto(votacionActualizada.getVoto());

            return votacionRepository.save(votacionExistente);
        } else {
            return null;
        }
    }

    @Override
    public void eliminarVotacion(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser null");
        }
        if (!votacionRepository.existsById(id)) {
            throw new IllegalArgumentException("No existe una votación con el ID: " + id);
        }
        votacionRepository.deleteById(id);
    }
}
