package com.biblioteca.proyecto_spring_redits.Controller;

import com.biblioteca.proyecto_spring_redits.Model.EncargoMenu;
import com.biblioteca.proyecto_spring_redits.Service.EncargoMenuService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/encargos")
public class EncargoController {
    private final EncargoMenuService encargoService;

    @GetMapping
    public List<EncargoMenu> listAll() {
        return encargoService.listAll();
    }

    @GetMapping("{id}")
    public EncargoMenu findById(@PathVariable int id) {
        return encargoService.findById(id);
    }

    @PostMapping
    public EncargoMenu create(@RequestBody EncargoMenu encargo) {
        return encargoService.save(encargo);
    }

    @PutMapping
    public EncargoMenu update(@RequestBody EncargoMenu encargo) {
        return encargoService.save(encargo);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        encargoService.delete(id);
    }
}