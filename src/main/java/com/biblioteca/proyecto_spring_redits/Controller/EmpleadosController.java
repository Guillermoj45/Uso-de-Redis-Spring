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
@RequestMapping("/empleado")

public class EmpleadosController {

    private final EmpleadosService empleadosService;

    private final PasswordEncoder passwordEncoder;

    public EmpleadosController(@Lazy EmpleadosService empleadosService,@Lazy PasswordEncoder passwordEncoder) {
        this.empleadosService = empleadosService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public List<Empleado> listAll() {
        return empleadosService.listAll();
    }

    @GetMapping("{id}")
    public Empleado findById(@PathVariable int id) {
        return empleadosService.findById(id);
    }

    @PostMapping
    public Empleado create(@RequestBody Empleado empleado) {
        return empleadosService.save(empleado);
    }

    @PutMapping
    public Empleado update(@RequestBody Empleado empleado) {
        return empleadosService.save(empleado);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        empleadosService.delete(id);
    }
}