package com.biblioteca.proyecto_spring_redits.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Empleado {
    @Id
    @Column(name = "id_empleado")
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id_empleado;

    @Column(name = "username",unique = true, length = 50)
    private String username;

    @Column(name = "password", length = 500)
    private String password;

    @Column(name = "role", length = 50)
    private String roles;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "apellido", length = 50)
    private String apellido;

    @Column(name = "direccion", length = 200)
    private String direccion;

    @Column(name = "telefono", length = 10, columnDefinition = "CHAR(10)")
    private String telefono;

}
