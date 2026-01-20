package com.benjamin.hogwarts.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "estudiante_asignatura")
public class EstudianteAsignatura {
    @EmbeddedId
    private EstudianteAsignaturaId id;
    
}
