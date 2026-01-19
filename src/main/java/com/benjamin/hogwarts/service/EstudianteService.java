package com.benjamin.hogwarts.service;

import com.benjamin.hogwarts.model.Estudiante;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EstudianteService {
    List<Estudiante> obtenerTodosLosEstudiantes();

    Estudiante obtenerEstudiantePorId(Long id);
}
