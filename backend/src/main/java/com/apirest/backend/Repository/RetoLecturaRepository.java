package com.apirest.backend.Repository;

import com.apirest.backend.Model.RetoLecturaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RetoLecturaRepository extends JpaRepository<RetoLecturaModel, Integer> {

    // Cuenta cuántas inscripciones hay en el reto
    @Query(value = "SELECT COUNT(*) FROM Inscripcion WHERE idReto = ?1", nativeQuery = true)
    int contarInscritosPorReto(Integer idReto);
}
