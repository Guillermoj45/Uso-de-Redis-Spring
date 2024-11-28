package com.biblioteca.proyecto_spring_redits.Controller;

import com.biblioteca.proyecto_spring_redits.Model.Cliente;
import com.biblioteca.proyecto_spring_redits.Model.Empleado;
import com.biblioteca.proyecto_spring_redits.Model.EncargoMenu;
import com.biblioteca.proyecto_spring_redits.Model.Menu;
import com.biblioteca.proyecto_spring_redits.Service.ClienteService;
import com.biblioteca.proyecto_spring_redits.Service.EmpleadosService;
import com.biblioteca.proyecto_spring_redits.Service.EncargoMenuService;
import com.biblioteca.proyecto_spring_redits.Service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;

import java.text.Format;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@Controller
public class PaginasController {
    private final MenuService menuService;

    /**
     * Método que devuelve la vista de los menús
     * @param model Modelo de la vista
     * @return HTML de la vista
     */
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("menus", menuService.listAll());
        return "Pantallas/Index";
    }
}
