package com.benjamin.hogwarts.service;

import com.benjamin.hogwarts.model.Casa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CasaService {
    List<Casa> obtenerTodasCasas();

    Casa obtenerCasaPorId(Long id);
}
