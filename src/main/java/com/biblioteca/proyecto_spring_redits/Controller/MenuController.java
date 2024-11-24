package com.biblioteca.proyecto_spring_redits.Controller;

import com.biblioteca.proyecto_spring_redits.Model.Menu;
import com.biblioteca.proyecto_spring_redits.Service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/menu")
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete2(@PathVariable Integer id) {
        menuService.delete(id);
        return ResponseEntity.ok().build();
    }
}