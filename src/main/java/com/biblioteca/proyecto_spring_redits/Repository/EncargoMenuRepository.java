package com.biblioteca.proyecto_spring_redits.Repository;

import com.biblioteca.proyecto_spring_redits.Model.EncargoMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncargoMenuRepository extends JpaRepository<EncargoMenu, Integer> {
}
