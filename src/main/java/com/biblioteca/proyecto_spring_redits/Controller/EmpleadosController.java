// EmpleadosController.java
package com.biblioteca.proyecto_spring_redits.Controller;

import com.biblioteca.proyecto_spring_redits.Model.Empleados;
import com.biblioteca.proyecto_spring_redits.Service.EmpleadosService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/empleados")
public class EmpleadosController {
    private final EmpleadosService empleadosService;

    @GetMapping
    public List<Empleados> listAll() {
        return empleadosService.listAll();
    }

    @GetMapping("{id}")
    public Empleados findById(@PathVariable int id) {
        return empleadosService.findById(id);
    }

    @PostMapping
    public Empleados create(@RequestBody Empleados empleados) {
        return empleadosService.save(empleados);
    }

    @PutMapping
    public Empleados update(@RequestBody Empleados empleados) {
        return empleadosService.save(empleados);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        empleadosService.delete(id);
    }
}