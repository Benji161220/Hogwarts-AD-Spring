package com.benjamin.hogwarts.service;

import com.benjamin.hogwarts.model.Profesor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfesorService {
    List<Profesor> obtenerTodosLosProfesores();

    Profesor obtenerProfesorPorId(Long id);
}
