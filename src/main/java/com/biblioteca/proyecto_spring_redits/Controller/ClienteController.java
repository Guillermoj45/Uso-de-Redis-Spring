package com.biblioteca.proyecto_spring_redits.Controller;

import com.biblioteca.proyecto_spring_redits.Model.Cliente;
import com.biblioteca.proyecto_spring_redits.Service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    /**
     * Método que devuelve la vista de los clientes
     * @param model Modelo de la vista
     * @return HTML de la vista
     */
    @GetMapping
    public String clientes(Model model) {
        model.addAttribute("clientes", clienteService.listAll());
        return "Pantallas/Clientes";
    }

    /**
     * Método que devulelve el HTML de la vista de registro de clientes
     * @param model Modelo de la vista
     * @return HTML de la vista
     */
    @GetMapping("/nuevo")
    public String clienteNew(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "Registro/modificacion/RegistroClientes";
    }

    /**
     * Método que guarda un cliente en la base de datos
     * @param cliente Cliente a guardar
     * @return Redirección a la vista de clientes
     */
    @PostMapping("/nuevo")
    public String clienteNew (@ModelAttribute Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/clientes";
    }

    /**
     * Método que devuelve la vista de un cliente en concreto
     * @param id ID del cliente
     * @param model Modelo de la vista
     * @return HTML de la vista
     */
    @GetMapping("{id}")
    public String clientes(@PathVariable int id, Model model) {
        model.addAttribute("cliente", clienteService.findById(id));
        return "Registro/modificacion/RegistroClientes";
    }


    /**
     * Método que actualiza un cliente en la base de datos
     * @param cliente Cliente a Añadir
     * @return redirección a la vista de clientes
     */
    @PostMapping
    public String registrarCliente(@ModelAttribute Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/clientes";
    }

    /**
     * Método actualiza un cliente en la base de datos
     * @param cliente Cliente a actualizar
     * @return Redirección a la vista de clientes
     */
    @PutMapping
    public Cliente update(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    /**
     * Método que devuelve una lista de clientes
     * @param id ID del cliente
     */
    @DeleteMapping("{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        clienteService.delete(id);
    }
}