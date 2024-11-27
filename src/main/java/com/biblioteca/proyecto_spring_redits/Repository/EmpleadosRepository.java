package com.biblioteca.proyecto_spring_redits.Repository;

import com.biblioteca.proyecto_spring_redits.Model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpleadosRepository extends JpaRepository<Empleado, Integer> {
    Optional<Empleado> findByUsername(String usuario);


}
