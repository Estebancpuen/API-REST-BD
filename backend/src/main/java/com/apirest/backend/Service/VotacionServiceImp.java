package com.apirest.backend.Service;

import com.apirest.backend.Model.VotacionModel;
import com.apirest.backend.Repository.VotacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
        votacionRepository.deleteById(id);
    }
}
