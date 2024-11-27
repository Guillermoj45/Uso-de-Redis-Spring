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
    private final ClienteService clienteService;
    private final EmpleadosService empleadoService;
    private final EncargoMenuService encargoMenuService;
    private final PasswordEncoder passwordEncoder;


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("menus", menuService.listAll());
        return "Pantallas/Index";
    }



    @GetMapping("encargo/")
    public String encargos(Model model) {
        model.addAttribute("encargos", encargoMenuService.listAll());
        return "Pantallas/Encargos";
    }

    @GetMapping("encargo/nuevo")
    public String encargoNew(Model model) {
        model.addAttribute("encargo", new EncargoMenu());
        model.addAttribute("fecha", "");
        return "Registro/modificacion/RegistroEncargos";
    }

    @PostMapping("encargo/nuevo")
    public String encargoNew (@ModelAttribute EncargoMenu encargo) {
        Menu menu = menuService.findByNombre(encargo.getMenu().getNombre());
        Cliente cliente = clienteService.findByName(encargo.getCliente().getNombre());
        encargo.setMenu(menu);
        encargo.setCliente(cliente);
        encargo.setFechaEncargo(LocalDate.now());
        encargoMenuService.save(encargo);
        return "redirect:/encargo/";
    }

    @GetMapping("encargo/{id}")
    public String encargo(@PathVariable int id, Model model) {
        EncargoMenu encargoMenu = encargoMenuService.findById(id);
        model.addAttribute("encargo", encargoMenu);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String s = encargoMenu.getFechaEncargo().format(formatter);
        model.addAttribute("fecha", s);

        return "Registro/modificacion/RegistroEncargos";
    }

    @GetMapping("empleados")
    public String empleados(Model model){
        model.addAttribute("empleados", empleadoService.listAll());
        return "Pantallas/Empleados";
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
        return "redirect:/empleados";
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
}
