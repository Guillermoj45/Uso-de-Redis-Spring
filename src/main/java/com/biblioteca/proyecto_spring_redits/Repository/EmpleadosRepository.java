package com.biblioteca.proyecto_spring_redits.Repository;

import com.biblioteca.proyecto_spring_redits.Model.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadosRepository extends JpaRepository<Empleados, Integer> {
}
