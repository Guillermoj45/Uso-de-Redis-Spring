// MenuController.java
package com.biblioteca.proyecto_spring_redits.Controller;

import com.biblioteca.proyecto_spring_redits.Model.Menu;
import com.biblioteca.proyecto_spring_redits.Service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/menus")
public class MenuController {
    private final MenuService menuService;

    @GetMapping
    public List<Menu> listAll() {
        return menuService.listAll();
    }

    @GetMapping("{id}")
    public Menu findById(@PathVariable int id) {
        return menuService.listById(id);
    }

    @PostMapping
    public Menu create(@RequestBody Menu menu) {
        return menuService.save(menu);
    }

    @PutMapping
    public Menu update(@RequestBody Menu menu) {
        return menuService.save(menu);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        menuService.delete(id);
    }
}