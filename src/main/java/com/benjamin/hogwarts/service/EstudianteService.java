package com.benjamin.hogwarts.service;

import com.benjamin.hogwarts.dtos.request.create.EstudianteCreateDTO;
import com.benjamin.hogwarts.dtos.request.update.EstudianteUpdateDTO;
import com.benjamin.hogwarts.dtos.response.EstudianteDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EstudianteService {
    List<EstudianteDTO> obtenerTodosLosEstudiantes();

    EstudianteDTO obtenerEstudiantePorId(Long id);

    EstudianteDTO crearEstudiante(EstudianteCreateDTO dto);

    EstudianteDTO actualizarEstudiante(Long id, EstudianteUpdateDTO dto);

    void eliminarEstudiante(Long id);
}
