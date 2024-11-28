package com.biblioteca.proyecto_spring_redits.Controller;

import com.biblioteca.proyecto_spring_redits.Model.Cliente;
import com.biblioteca.proyecto_spring_redits.Model.EncargoMenu;
import com.biblioteca.proyecto_spring_redits.Model.Menu;
import com.biblioteca.proyecto_spring_redits.Service.ClienteService;
import com.biblioteca.proyecto_spring_redits.Service.EncargoMenuService;
import com.biblioteca.proyecto_spring_redits.Service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@Controller
@RequestMapping("/encargo")
public class EncargoController {
    private final EncargoMenuService encargoService;
    private final MenuService menuService;
    private final ClienteService clienteService;


    /**
     * Método que devuelve la vista de los encargos
     * @param model Modelo de la vista
     * @return HTML de la vista
     */
    @GetMapping
    public String encargos(Model model) {
        model.addAttribute("encargos", encargoService.listAll());
        return "Pantallas/Encargos";
    }

    /**
     * Método que devulelve el HTML de la vista de registro de encargos
     * @param model Modelo de la vista
     * @return HTML de la vista
     */
    @GetMapping("nuevo")
    public String encargoNew(Model model) {
        model.addAttribute("encargo", new EncargoMenu());
        model.addAttribute("fecha", "");
        return "Registro/modificacion/RegistroEncargos";
    }

    /**
     * Método que guarda un encargo en la base de datos
     * @param encargo Encargo a guardar
     * @return Redirección a la vista de encargos
     */
    @PostMapping
    public String encargoNew (@ModelAttribute EncargoMenu encargo) {
        Menu menu = menuService.findByNombre(encargo.getMenu().getNombre());
        Cliente cliente = clienteService.findByName(encargo.getCliente().getNombre());
        encargo.setMenu(menu);
        encargo.setCliente(cliente);
        encargo.setFechaEncargo(LocalDate.now());
        encargoService.save(encargo);
        return "redirect:/encargo";
    }

    /**
     * Método que devuelve la vista de un encargo en concreto
     * @param id ID del encargo
     * @param model Modelo de la vista
     * @return HTML de la vista
     */
    @GetMapping("{id}")
    public String encargo(@PathVariable int id, Model model) {
        EncargoMenu encargoMenu = encargoService.findById(id);
        model.addAttribute("encargo", encargoMenu);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String s = encargoMenu.getFechaEncargo().format(formatter);
        model.addAttribute("fecha", s);

        return "Registro/modificacion/RegistroEncargos";
    }

    /**
     * Método que actualiza un encargo en la base de datos
     * @param encargo Encargo a Añadir
     * @return redirección a la vista de encargos
     */
    @PutMapping
    public EncargoMenu update(@RequestBody EncargoMenu encargo) {
        return encargoService.save(encargo);
    }

    /**
     * Método que elimina un encargo de la base de datos
     * @param id ID del encargo
     */
    @DeleteMapping("{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        encargoService.delete(id);
    }
}