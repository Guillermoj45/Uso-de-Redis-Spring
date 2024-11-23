package com.biblioteca.proyecto_spring_redits.Service;

import com.biblioteca.proyecto_spring_redits.Model.Cliente;

import java.util.List;

public interface IClienteService {
    public List<Cliente> listAll();

    public Cliente findById(int id);

    public Cliente save(Cliente cliente);

    public void delete(int id);
}
