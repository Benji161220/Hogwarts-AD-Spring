package com.benjamin.hogwarts.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "mascota")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private Long id;

    private String nombre;

    private String especie;

    @Column(name = "id_estudiante")
    private int idEstudiante;
}
