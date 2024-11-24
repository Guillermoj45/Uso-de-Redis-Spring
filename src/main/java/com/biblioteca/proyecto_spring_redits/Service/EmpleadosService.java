package com.biblioteca.proyecto_spring_redits.Service;

import com.biblioteca.proyecto_spring_redits.Model.Empleado;
import com.biblioteca.proyecto_spring_redits.Repository.EmpleadosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmpleadosService implements IEmpleadosService {
    private final EmpleadosRepository empleadosRepository;


    public Optional<Empleado> findByUsername(String usuario) {
        return empleadosRepository.findByUsername(usuario);
    }

    @Override
    public List<Empleado> listAll() {
        return empleadosRepository.findAll();
    }

    @Override
    public Empleado findById(int id) {
        return empleadosRepository.findById(id).orElse(null);
    }

    @Override
    public Empleado save(Empleado empleado) {
        return empleadosRepository.saveAndFlush(empleado);
    }

    @Override
    public void delete(int id) {
        empleadosRepository.deleteById(id);
    }
}
