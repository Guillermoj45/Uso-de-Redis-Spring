package com.biblioteca.proyecto_spring_redits.Service;

import com.biblioteca.proyecto_spring_redits.Model.Empleado;

import java.util.List;

public interface IEmpleadosService {
    public List<Empleado> listAll();

    public Empleado findById(int id);

    public Empleado save(Empleado empleado);

    public void delete(int id);
}
