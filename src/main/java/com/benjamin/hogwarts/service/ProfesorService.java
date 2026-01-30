package com.benjamin.hogwarts.service;

import com.benjamin.hogwarts.dtos.response.ProfesorDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfesorService {
    List<ProfesorDTO> obtenerTodosLosProfesores();

    ProfesorDTO obtenerProfesorPorId(Long id);
}
