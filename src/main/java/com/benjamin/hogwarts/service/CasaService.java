package com.benjamin.hogwarts.service;

import com.benjamin.hogwarts.dtos.response.CasaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CasaService {
    List<CasaDTO> obtenerTodasCasas();

    CasaDTO obtenerCasaPorId(Long id);
}
