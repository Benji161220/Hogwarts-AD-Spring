package com.benjamin.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "estudiante")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Long id;

    private String nombre;

    private String apellido;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_casa")
    private Casa casa;

    @Column(name = "anyo_curso")
    private int anyoCurso;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @OneToOne(mappedBy = "estudiante")
    @JsonManagedReference
    private Mascota mascota;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "estudiante-asignaturas")
    private List<EstudianteAsignatura> asignaturas = new ArrayList<>();
}
