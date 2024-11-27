package com.biblioteca.proyecto_spring_redits.Controller;

import com.biblioteca.proyecto_spring_redits.Model.Menu;
import com.biblioteca.proyecto_spring_redits.Service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("nuevo")
    public String registrarMenu(Model model) {
        model.addAttribute("menu", new Menu());
        return "Registro/modificacion/RegistroMenu";
    }

    @PostMapping
    public String clienteNew (@ModelAttribute Menu menu) {
        menuService.save(menu);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String editarMenu(Model model, @PathVariable int id) {
        model.addAttribute("menu", menuService.listById(id));
        return "Registro/modificacion/RegistroMenu";
    }


    @PutMapping
    public Menu update(@RequestBody Menu menu) {
        return menuService.save(menu);
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        menuService.delete(id);
    }
}