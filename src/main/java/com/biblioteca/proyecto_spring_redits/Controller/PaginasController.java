package com.biblioteca.proyecto_spring_redits.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginasController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
