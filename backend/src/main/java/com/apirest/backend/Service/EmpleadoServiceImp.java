package com.apirest.backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.Exception.RecursoNoEncontradoException;
import com.apirest.backend.Model.EmpleadoModel;
import com.apirest.backend.Repository.IEmpleadoRepository;
@Service
public class EmpleadoServiceImp implements IEmpleadoService{
    @Autowired IEmpleadoRepository empleadoRepository;
    @Override
    public EmpleadoModel guardarEmpleado(EmpleadoModel empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public List<EmpleadoModel> listarEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public EmpleadoModel buscarEmpleadoPorId(Integer id) {
        return empleadoRepository.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Error! El empleado con el ID "+id+", no se encuentra en la BD"));
    }

    @Override
    public EmpleadoModel actualizarEmpleado(Integer id, EmpleadoModel empleado) {
       // buscamos al empleado
       EmpleadoModel empleadoexistente = buscarEmpleadoPorId(id);
       empleadoexistente.setNombre(empleado.getNombre());
       return empleadoRepository.save(empleadoexistente);
    }

    @Override
    public String eliminarEmpleado(Integer id) {
       // buscamos al empleado
       EmpleadoModel empleadoexistente = buscarEmpleadoPorId(id);
       //a eliminar al empleado si y solo si existe
       empleadoRepository.delete(empleadoexistente);
       return "El empleado con ID "+ id+", se eliminó con éxito.";
    }
    
}
