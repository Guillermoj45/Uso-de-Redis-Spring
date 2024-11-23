package com.biblioteca.proyecto_spring_redits.Service;

import com.biblioteca.proyecto_spring_redits.Model.Menu;

import java.util.List;

public interface IMenuService {
    public List<Menu> listAll();

    public Menu listById(int id);

    public Menu save(Menu menu);

    public void delete(int id);
}
