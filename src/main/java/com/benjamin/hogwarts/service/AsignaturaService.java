package com.benjamin.hogwarts.service;

import com.benjamin.hogwarts.dtos.response.AsignaturaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AsignaturaService {
    List<AsignaturaDTO> obtenerTodasAsignaturas();

    AsignaturaDTO obtenerAsignaturaPorId(Long id);
}
