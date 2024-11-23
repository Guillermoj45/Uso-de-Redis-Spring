package com.biblioteca.proyecto_spring_redits.Service;

import com.biblioteca.proyecto_spring_redits.Model.Empleados;

import java.util.List;

public interface IEmpleadosService {
    public List<Empleados> listAll();

    public Empleados findById(int id);

    public Empleados save(Empleados empleados);

    public void delete(int id);
}
