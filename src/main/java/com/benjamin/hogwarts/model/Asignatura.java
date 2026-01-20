package com.benjamin.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "asignatura")
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignatura")
    private Long id;

    @Column(unique = true)
    private String nombre;

    private String aula;

    private boolean obligatoria;

    @OneToMany(mappedBy = "asignatura", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference(value = "asignatura-estudiantes")
    private List<EstudianteAsignatura> estudiantesAsignaturas = new ArrayList<>();

    @OneToOne(mappedBy = "asignatura")
    @JsonManagedReference
    private Profesor profesor;
}
