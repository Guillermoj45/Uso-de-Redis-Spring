package com.biblioteca.proyecto_spring_redits.Controller;

import com.biblioteca.proyecto_spring_redits.Model.Empleado;
import com.biblioteca.proyecto_spring_redits.Service.EmpleadosService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/empleados")

public class EmpleadosController {

    private final EmpleadosService empleadosService;

    private final PasswordEncoder passwordEncoder;

    public EmpleadosController(@Lazy EmpleadosService empleadosService,@Lazy PasswordEncoder passwordEncoder) {
        this.empleadosService = empleadosService;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping
    public String empleados(Model model){
        model.addAttribute("empleados", empleadosService.listAll());
        return "Pantallas/Empleados";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeRegistro(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "Registro/modificacion/RegistroEmpleados";
    }

    @PostMapping
    public String registrarEmpleado(Empleado empleado) {
        if (empleado.getId() != 0) {
            empleado.setPassword(passwordEncoder.encode(empleado.getPassword()));
        }
        if (empleado.getPassword().isBlank() && empleado.getId() != 0) {
            empleado.setPassword(empleadosService.findById(empleado.getId()).getPassword());
        }
        empleadosService.save(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/edit/{id}")
    public String mostrarFormularioModificacion(Model model, @PathVariable int id) {
        model.addAttribute("empleado", empleadosService.findById(id));
        return "Registro/modificacion/ModificarEmpleados";
    }

    @PostMapping("/edit/{id}")
    public String mostrarFormularioModificacionRecepcion(Empleado empleado) {
        if (empleado.getId() != 0) {
            Empleado existingEmpleado = empleadosService.findById(empleado.getId());
            if (existingEmpleado != null) {
                empleado.setPassword(existingEmpleado.getPassword());
            }
        } else {
            empleado.setPassword(passwordEncoder.encode(empleado.getPassword()));
        }
        empleadosService.save(empleado);
        return "redirect:/empleado";
    }



    @PutMapping
    public Empleado update(@RequestBody Empleado empleado) {
        return empleadosService.save(empleado);
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        empleadosService.delete(id);
    }
}