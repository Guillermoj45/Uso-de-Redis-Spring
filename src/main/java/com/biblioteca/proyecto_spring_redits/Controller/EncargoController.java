package com.biblioteca.proyecto_spring_redits.Controller;

import com.biblioteca.proyecto_spring_redits.Model.Cliente;
import com.biblioteca.proyecto_spring_redits.Model.EncargoMenu;
import com.biblioteca.proyecto_spring_redits.Model.Menu;
import com.biblioteca.proyecto_spring_redits.Service.ClienteService;
import com.biblioteca.proyecto_spring_redits.Service.EmpleadosService;
import com.biblioteca.proyecto_spring_redits.Service.EncargoMenuService;
import com.biblioteca.proyecto_spring_redits.Service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/encargo")
public class EncargoController {
    private final EncargoMenuService encargoService;
    private final MenuService menuService;
    private final ClienteService clienteService;


    @GetMapping
    public String encargos(Model model) {
        model.addAttribute("encargos", encargoService.listAll());
        return "Pantallas/Encargos";
    }

    @GetMapping("nuevo")
    public String encargoNew(Model model) {
        model.addAttribute("encargo", new EncargoMenu());
        model.addAttribute("fecha", "");
        return "Registro/modificacion/RegistroEncargos";
    }

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

    @GetMapping("{id}")
    public String encargo(@PathVariable int id, Model model) {
        EncargoMenu encargoMenu = encargoService.findById(id);
        model.addAttribute("encargo", encargoMenu);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String s = encargoMenu.getFechaEncargo().format(formatter);
        model.addAttribute("fecha", s);

        return "Registro/modificacion/RegistroEncargos";
    }

    @PutMapping
    public EncargoMenu update(@RequestBody EncargoMenu encargo) {
        return encargoService.save(encargo);
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        encargoService.delete(id);
    }
}