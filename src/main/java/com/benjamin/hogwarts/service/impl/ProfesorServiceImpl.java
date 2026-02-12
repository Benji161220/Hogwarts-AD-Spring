package com.benjamin.hogwarts.service.impl;

import com.benjamin.hogwarts.dtos.response.ProfesorDTO;
import com.benjamin.hogwarts.mappers.ProfesorMapper;
import com.benjamin.hogwarts.respository.ProfesorRepository;
import com.benjamin.hogwarts.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService {
    private final ProfesorRepository profesorRepository;
    private final ProfesorMapper profesorMapper;

    @Autowired
    public ProfesorServiceImpl(ProfesorRepository profesorRepository, ProfesorMapper profesorMapper) {
        this.profesorRepository = profesorRepository;
        this.profesorMapper = profesorMapper;
    }

    @Override
    public List<ProfesorDTO> obtenerTodosLosProfesores() {
        return profesorRepository.findAll()
                .stream()
                .map(profesorMapper::toDTO)
                .toList();
    }

    @Override
    public ProfesorDTO obtenerProfesorPorId(Long id) {
        return profesorRepository.findById(id).map(profesorMapper::toDTO).orElse(null);
    }
}
