package com.benjamin.hogwarts.respository;

import com.benjamin.hogwarts.model.EstudianteAsignatura;
import com.benjamin.hogwarts.model.EstudianteAsignaturaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteAsignaturaRepository extends JpaRepository<EstudianteAsignatura, EstudianteAsignaturaId> {
}
