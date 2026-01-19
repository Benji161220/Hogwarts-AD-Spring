package com.benjamin.hogwarts.respository;

import com.benjamin.hogwarts.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRespository extends JpaRepository<Estudiante, Long> {
}
