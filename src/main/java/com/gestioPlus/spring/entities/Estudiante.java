package com.gestioPlus.spring.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "estudiantes")
@Data
public class Estudiante {
    @Id
    @Column(name = "cedula")
    private String cedula;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "telefono")
    private String telefono;


}
