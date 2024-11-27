package com.biblioteca.proyecto_spring_redits.Controller;

import com.biblioteca.proyecto_spring_redits.Model.Cliente;
import com.biblioteca.proyecto_spring_redits.Service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    @GetMapping
    public String clientes(Model model) {
        model.addAttribute("clientes", clienteService.listAll());
        return "Pantallas/Clientes";
    }

    @GetMapping("/nuevo")
    public String clienteNew(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "Registro/modificacion/RegistroClientes";
    }

    @PostMapping("/nuevo")
    public String clienteNew (@ModelAttribute Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("{id}")
    public String clientes(@PathVariable int id, Model model) {
        model.addAttribute("cliente", clienteService.findById(id));
        return "Registro/modificacion/RegistroClientes";
    }

    @PostMapping
    public String registrarCliente(@ModelAttribute Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/clientes";
    }

    @PutMapping
    public Cliente update(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        clienteService.delete(id);
    }
}