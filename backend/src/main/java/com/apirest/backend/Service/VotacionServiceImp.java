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

        // DB: idUsuario, idPropuesta y voto son NOT NULL
        if (votacion.getUsuario() == null || votacion.getUsuario().getIdUsuario() == null) {
            throw new IllegalArgumentException("La votación debe tener un usuario válido");
        }
        if (votacion.getPropuesta() == null || votacion.getPropuesta().getIdPropuesta() == null) {
            throw new IllegalArgumentException("La votación debe referenciar una propuesta válida");
        }

        return votacionRepository.save(votacion);
    }

    @Override
    public VotacionModel obtenerPorId(Integer id) {

        Optional<VotacionModel> votacion = votacionRepository.findById(id);
        return votacion.orElse(null);
    }

    @Override
    public VotacionModel actualizarVotacion(Integer id, VotacionModel votacionActualizada) {

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

        if (!votacionRepository.existsById(id)) {
            throw new IllegalArgumentException("No existe una votación con el ID: " + id);
        }
        votacionRepository.deleteById(id);
    }
}
