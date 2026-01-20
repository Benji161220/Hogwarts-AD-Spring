package com.benjamin.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "estudiante_asignatura")
public class EstudianteAsignatura {
    @EmbeddedId
    private EstudianteAsignaturaId id = new EstudianteAsignaturaId();

    @ManyToOne
    @MapsId("idEstudiante")
    @JoinColumn(name = "id_estudiante")
    @JsonBackReference(value = "estudiante-asignaturas")
    private Estudiante estudiante;

    @ManyToOne
    @MapsId("idAsignatura")
    @JoinColumn(name = "id_asignatura")
    // esta referencia se serializa para que al solicitar un estudiante aparezca la asignatura y calificación
    @JsonManagedReference(value = "asignatura-estudiantes")
    private Asignatura asignatura;

    @Column(precision = 3, scale = 1)
    private BigDecimal calificacion;
}
