package com.biblioteca.proyecto_spring_redits.Controller;

import com.biblioteca.proyecto_spring_redits.Model.Cliente;
import com.biblioteca.proyecto_spring_redits.Model.Empleado;
import com.biblioteca.proyecto_spring_redits.Model.Menu;
import com.biblioteca.proyecto_spring_redits.Service.ClienteService;
import com.biblioteca.proyecto_spring_redits.Service.EmpleadosService;
import com.biblioteca.proyecto_spring_redits.Service.EncargoMenuService;
import com.biblioteca.proyecto_spring_redits.Service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;

@AllArgsConstructor
@Controller
public class PaginasController {
    private final MenuService menuService;
    private final ClienteService clienteService;
    private final EmpleadosService empleadoService;
    private final EncargoMenuService encargoMenuService;
    private final PasswordEncoder passwordEncoder;
    private final SpringResourceTemplateResolver defaultTemplateResolver;


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("menus", menuService.listAll());
        return "Pantallas/Index";
    }

    @GetMapping("clientes")
    public String clientes(Model model) {
        model.addAttribute("clientes", clienteService.listAll());
        return "Pantallas/Clientes";
    }

    @GetMapping("clientes/{id}")
    public String clientes(@PathVariable int id, Model model) {
        model.addAttribute("cliente", clienteService.findById(id));
        return "Cliente";
    }

    @GetMapping("empleados/nuevo")
    public String empleadosNew(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "Registro/modificacion/RegistroEmpleados";
    }

    @GetMapping("empleados")
    public String empleados(Model model){
        model.addAttribute("empleados", empleadoService.listAll());
        return "Pantallas/Empleados";
    }


    @GetMapping("encargo/")
    public String encargos(Model model) {
        model.addAttribute("encargos", encargoMenuService.listAll());
        return "Pantallas/Encargos";
    }

    @GetMapping("empleado/nuevo")
    public String mostrarFormularioDeRegistro(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "Registro/modificacion/RegistroEmpleados";
    }

    @PostMapping("empleado/nuevo")
    public String registrarEmpleado(Empleado empleado) {
        empleado.setPassword(passwordEncoder.encode(empleado.getPassword()));
        empleadoService.save(empleado);
        return "redirect:/";
    }

    @GetMapping("empleado/edit/{id}")
    public String mostrarFormularioModificacion(Model model, @PathVariable int id) {
        model.addAttribute("empleado", empleadoService.findById(id));
        return "Registro/modificacion/ModificarEmpleados";
    }

    @PostMapping("empleado/edit/{id}")
    public String mostrarFormularioModificacionRecepcion(Empleado empleado) {
        if (empleado.getId() != 0) {
            Empleado existingEmpleado = empleadoService.findById(empleado.getId());
            if (existingEmpleado != null) {
                empleado.setPassword(existingEmpleado.getPassword());
            }
        } else {
            empleado.setPassword(passwordEncoder.encode(empleado.getPassword()));
        }
        empleadoService.save(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("menu/nuevo")
    public String registrarMenu(Model model) {
        model.addAttribute("menu", new Menu());
        return "Registro/modificacion/RegistroMenu";
    }

    @GetMapping("menu/edit/{id}")
    public String editarMenu(Model model,@PathVariable int id) {
        model.addAttribute("menu", menuService.listById(id));
        return "Registro/modificacion/RegistroMenu";
    }

    @PostMapping("menu/edit/{id}")
    public String editarMenu(Menu menu) {
        menuService.save(menu);
        return "redirect:/";
    }

    @PostMapping("clientes/edit/{id}")
    public String registrarCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "redirect:/";
    }
}
