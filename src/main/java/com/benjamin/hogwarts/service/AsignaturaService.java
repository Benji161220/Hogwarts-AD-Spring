package com.benjamin.hogwarts.service;

import com.benjamin.hogwarts.model.Asignatura;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AsignaturaService {
    List<Asignatura> obtenerTodasAsignaturas();

    Asignatura obtenerAsignaturaPorId(Long id);
}
