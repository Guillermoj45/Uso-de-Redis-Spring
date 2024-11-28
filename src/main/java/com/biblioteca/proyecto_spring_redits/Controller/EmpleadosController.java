package com.biblioteca.proyecto_spring_redits.Controller;

import com.biblioteca.proyecto_spring_redits.Model.Empleado;
import com.biblioteca.proyecto_spring_redits.Service.EmpleadosService;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/empleados")

public class EmpleadosController {

    private final EmpleadosService empleadosService;

    private final PasswordEncoder passwordEncoder;

    public EmpleadosController(@Lazy EmpleadosService empleadosService,@Lazy PasswordEncoder passwordEncoder) {
        this.empleadosService = empleadosService;
        this.passwordEncoder = passwordEncoder;
    }


    /**
     * Método que devuelve la vista de los empleados
     * @param model Modelo de la vista
     * @return HTML de la vista
     */
    @GetMapping
    public String empleados(Model model){
        model.addAttribute("empleados", empleadosService.listAll());
        return "Pantallas/Empleados";
    }


    /**
     * Método que devulelve el HTML de la vista de registro de empleados
     * @param model Modelo de la vista
     * @return HTML de la vista
     */
    @GetMapping("/nuevo")
    public String mostrarFormularioDeRegistro(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "Registro/modificacion/RegistroEmpleados";
    }

    /**
     * Método que guarda un empleado en la base de datos
     * @param empleado Empleado a guardar
     * @return Redirección a la vista de empleados
     */
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

    /**
     * Método que devuelve la vista de un empleado en concreto
     * @param id ID del empleado
     * @param model Modelo de la vista
     * @return HTML de la vista
     */
    @GetMapping("/edit/{id}")
    public String mostrarFormularioModificacion(Model model, @PathVariable int id) {
        model.addAttribute("empleado", empleadosService.findById(id));
        return "Registro/modificacion/ModificarEmpleados";
    }


    /**
     * Método que actualiza un empleado en la base de datos
     * @param empleado Empleado a Añadir
     * @return Empleado modificado
     */
    @PutMapping
    public Empleado update(@RequestBody Empleado empleado) {
        return empleadosService.save(empleado);
    }

    /**
     * Método que devuelve una lista de empleados
     * @param id ID del empleado
     */
    @DeleteMapping("{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        empleadosService.delete(id);
    }
}