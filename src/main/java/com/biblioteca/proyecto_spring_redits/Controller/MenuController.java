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


    /**
     * Método que devuelve la vista de los menús
     * @param model Modelo de la vista
     * @return HTML de la vista
     */
    @GetMapping("nuevo")
    public String registrarMenu(Model model) {
        model.addAttribute("menu", new Menu());
        return "Registro/modificacion/RegistroMenu";
    }

    /**
     * Método que guarda un menú en la base de datos
     * @param menu Menú a guardar
     * @return Redirección a la vista de menús
     */
    @PostMapping
    public String clienteNew (@ModelAttribute Menu menu) {
        menuService.save(menu);
        return "redirect:/";
    }

    /**
     * Método que devuelve la vista de los menús
     * @param model Modelo de la vista
     * @param id id del menú
     * @return HTML de la vista
     */
    @GetMapping("/{id}")
    public String editarMenu(Model model, @PathVariable int id) {
        model.addAttribute("menu", menuService.listById(id));
        return "Registro/modificacion/RegistroMenu";
    }

    /**
     * Método actualiza un menú en la base de datos
     * @param menu Menú a actualizar
     * @return El menú actualizado
     */
    @PutMapping
    public Menu update(@RequestBody Menu menu) {
        return menuService.save(menu);
    }

    /**
     * Método que elimina un menú de la base de datos
     * @param id id del menú a eliminar
     * @return HTML de la vista
     */
    @DeleteMapping("{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        menuService.delete(id);
    }
}