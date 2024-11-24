package com.biblioteca.proyecto_spring_redits.Service;

import com.biblioteca.proyecto_spring_redits.Model.Empleado;
import com.biblioteca.proyecto_spring_redits.Repository.EmpleadosRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static org.springframework.security.core.userdetails.User.withUsername;

@Service
@AllArgsConstructor
public class InicioSesionEmpleados implements UserDetailsService {
    private final EmpleadosRepository empleadosRepository;

    public Empleado build(){
        return new Empleado();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Empleado empleado = empleadosRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        User.UserBuilder builder = withUsername(empleado.getUsername());
        builder.password(empleado.getPassword());
        builder.roles(empleado.getRoles().split(","));
        return builder.build();
    }
}
