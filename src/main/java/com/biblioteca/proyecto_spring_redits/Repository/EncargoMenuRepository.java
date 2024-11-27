package com.biblioteca.proyecto_spring_redits.Repository;

import com.biblioteca.proyecto_spring_redits.Model.EncargoMenu;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EncargoMenuRepository extends JpaRepository<EncargoMenu, Integer> {
    @EntityGraph(attributePaths = {"menu", "cliente"})
    List<EncargoMenu> findAll();
}
