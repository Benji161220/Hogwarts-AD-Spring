package com.benjamin.hogwarts.service;

import com.benjamin.hogwarts.model.EstudianteAsignatura;
import com.benjamin.hogwarts.model.EstudianteAsignaturaId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EstudianteAsignaturaService {
    List<EstudianteAsignatura> obtenerTodas();

    EstudianteAsignatura obtenerPorId(EstudianteAsignaturaId id);
}
