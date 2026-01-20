package com.benjamin.hogwarts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class EstudianteAsignaturaId implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "id_estudiante")
    private Long idEstudiante;

    @Column(name = "id_asignatura")
    private Long idAsignatura;

    public EstudianteAsignaturaId() {}

    public EstudianteAsignaturaId(Long idEstudiante, Long idAsignatura) {
        this.idEstudiante = idEstudiante;
        this.idAsignatura = idAsignatura;
    }
}
