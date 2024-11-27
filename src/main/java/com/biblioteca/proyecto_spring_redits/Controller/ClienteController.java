package com.biblioteca.proyecto_spring_redits.Controller;

import com.biblioteca.proyecto_spring_redits.Model.Cliente;
import com.biblioteca.proyecto_spring_redits.Service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/cliente")
public class ClienteController {
    private final ClienteService clienteService;

    @GetMapping
    public List<Cliente> listAll() {
        return clienteService.listAll();
    }

    @GetMapping("{id}")
    public Cliente findById(@PathVariable int id) {
        return clienteService.findById(id);
    }

    @PostMapping
    public Cliente create(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @PutMapping
    public Cliente update(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        clienteService.delete(id);
    }
}