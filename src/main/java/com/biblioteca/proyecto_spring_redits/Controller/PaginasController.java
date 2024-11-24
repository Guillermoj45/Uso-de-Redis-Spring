package com.biblioteca.proyecto_spring_redits.Controller;

import com.biblioteca.proyecto_spring_redits.Service.ClienteService;
import com.biblioteca.proyecto_spring_redits.Service.EmpleadosService;
import com.biblioteca.proyecto_spring_redits.Service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor
@Controller
public class PaginasController {
    private final MenuService menuService;
    private final ClienteService clienteService;
    private final EmpleadosService empleadoService;


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("menus", menuService.listAll());
        return "index";
    }

    @GetMapping("clientes")
    public String clientes() {

        return "index";
    }
    @GetMapping("cliente/{id}")
    public String clientes(@PathVariable int id) {
        return "cliente";
    }

    @GetMapping("empleados")
    public String empleados() {
        return "index";
    }

    @GetMapping("empleado/{id}")
    public String empleados(@PathVariable int id) {
        return "empleado";
    }

    @GetMapping("compras")
    public String compras() {
        return "index";
    }
}
