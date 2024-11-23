package com.biblioteca.proyecto_spring_redits.Service;

import com.biblioteca.proyecto_spring_redits.Model.Empleados;
import com.biblioteca.proyecto_spring_redits.Repository.EmpleadosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmpleadosService implements IEmpleadosService {
    private final EmpleadosRepository empleadosRepository;

    @Override
    public List<Empleados> listAll() {
        return empleadosRepository.findAll();
    }

    @Override
    public Empleados findById(int id) {
        return empleadosRepository.findById(id).orElse(null);
    }

    @Override
    public Empleados save(Empleados empleados) {
        return empleadosRepository.save(empleados);
    }

    @Override
    public void delete(int id) {
        empleadosRepository.deleteById(id);
    }
}
