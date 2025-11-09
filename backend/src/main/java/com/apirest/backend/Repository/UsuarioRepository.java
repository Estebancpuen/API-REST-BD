package com.apirest.backend.Repository;

import com.apirest.backend.Model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
    // Aquí podrías agregar métodos de búsqueda personalizados si los necesitas, 
    // por ejemplo: UsuarioModel findByCorreoElectronico(String correo);
}
