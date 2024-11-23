package com.biblioteca.proyecto_spring_redits.Service;

import com.biblioteca.proyecto_spring_redits.Model.EncargoMenu;

import java.util.List;

public interface IEncargoMenuService {
    public List<EncargoMenu> listAll();

    public EncargoMenu findById(int id);

    public EncargoMenu save(EncargoMenu encargoMenu);

    public void delete(int id);
}
