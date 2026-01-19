package com.benjamin.hogwarts.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "profesor")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private Long id;

    private String nombre;

    private String apellido;

    @Column(name = "id_asignatura")
    private Integer idAsignatura;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;
}
