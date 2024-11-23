package com.biblioteca.proyecto_spring_redits.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class EncargoMenu {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Menu menu;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Cliente cliente;

    @Column(name = "fecha_encargo", nullable = false)
    @PrePersist
    protected void onCreate() {
        this.fechaEncargo = LocalDate.now();
    }
    private LocalDate fechaEncargo;

    @Column(name = "fecha_entrega", nullable = false)
    private LocalDate fechaEntrega;
}
