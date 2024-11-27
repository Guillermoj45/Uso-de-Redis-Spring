package com.biblioteca.proyecto_spring_redits.Service;


import com.biblioteca.proyecto_spring_redits.Model.Menu;
import com.biblioteca.proyecto_spring_redits.Repository.MenuRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MenuService implements IMenuService {
    private final MenuRepository encargoMenuRepository;


    @Override
    public List<Menu> listAll() {
        return encargoMenuRepository.findAll();
    }

    @Override
    public Menu findByNombre(String nombre) {
        return encargoMenuRepository.findByNombre(nombre);
    }

    @Override
    public Menu listById(int id) {
        return encargoMenuRepository.findById(id).orElse(null);
    }

    @Override
    public Menu save(Menu menu) {
        return encargoMenuRepository.save(menu);
    }

    @Override
    public void delete(int id) {
        encargoMenuRepository.deleteById(id);
    }
}
