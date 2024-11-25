package com.biblioteca.proyecto_spring_redits.Controller;

import com.biblioteca.proyecto_spring_redits.Model.Empleado;
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
    public String clientes(Model model) {
        model.addAttribute("clientes", clienteService.listAll());
        return "Clientes";
    }

    @GetMapping("clientes/{id}")
    public String clientes(@PathVariable int id, Model model) {
        model.addAttribute("cliente", clienteService.findById(id));
        return "Cliente";
    }

    @GetMapping("empleados/nuevo")
    public String empleadosNew(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "registro";
    }

    @GetMapping("empleados")
    public String empleados(Model model){
        model.addAttribute("empleados", empleadoService.listAll());
        return "Empleados";
    }
}
