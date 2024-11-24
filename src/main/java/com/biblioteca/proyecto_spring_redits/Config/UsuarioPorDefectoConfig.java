package com.biblioteca.proyecto_spring_redits.Config;

import com.biblioteca.proyecto_spring_redits.Model.Empleado;
import com.biblioteca.proyecto_spring_redits.Service.EmpleadosService;
import com.biblioteca.proyecto_spring_redits.Service.IEmpleadosService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@AllArgsConstructor
public class UsuarioPorDefectoConfig {
    private EmpleadosService empleadosService;


    private PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner createDefaultUser() {
        return args -> {
            if (empleadosService.findByUsername("admin").isEmpty()) {
                Empleado defaultEmpleado = new Empleado();
                defaultEmpleado.setUsername("admin");
                defaultEmpleado.setPassword(passwordEncoder.encode("admin123"));
                defaultEmpleado.setRoles("admin");
                defaultEmpleado.setNombre("Admin");
                defaultEmpleado.setApellido("User");
                defaultEmpleado.setDireccion("Default Address");
                defaultEmpleado.setTelefono("1234567890");
                empleadosService.save(defaultEmpleado);
            }
        };
    }
}