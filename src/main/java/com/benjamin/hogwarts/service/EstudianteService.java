package com.benjamin.hogwarts.service;

import com.benjamin.hogwarts.dtos.response.EstudianteDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EstudianteService {
    List<EstudianteDTO> obtenerTodosLosEstudiantes();

    EstudianteDTO obtenerEstudiantePorId(Long id);
}
