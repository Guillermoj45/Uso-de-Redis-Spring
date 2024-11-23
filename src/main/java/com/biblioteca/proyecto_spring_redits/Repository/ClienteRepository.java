package com.biblioteca.proyecto_spring_redits.Repository;

import com.biblioteca.proyecto_spring_redits.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
