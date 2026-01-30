package com.benjamin.hogwarts.service.impl;

import com.benjamin.hogwarts.dtos.response.EstudianteDTO;
import com.benjamin.hogwarts.mappers.EstudianteMapper;
import com.benjamin.hogwarts.model.Estudiante;
import com.benjamin.hogwarts.respository.EstudianteRespository;
import com.benjamin.hogwarts.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService {
    private final EstudianteRespository estudianteRespository;
    private final EstudianteMapper estudianteMapper;

    @Autowired
    public EstudianteServiceImpl(EstudianteRespository estudianteRespository, EstudianteMapper estudianteMapper) {
        this.estudianteRespository = estudianteRespository;
        this.estudianteMapper = estudianteMapper;
    }
    @Override
    public List<EstudianteDTO> obtenerTodosLosEstudiantes(){
        return estudianteRespository.findAll().stream()
                .map(estudianteMapper::toDTO)
                .toList();
    }

    @Override
    public EstudianteDTO obtenerEstudiantePorId(Long id) {
        return estudianteRespository.findById(id)
                .map(estudianteMapper::toDTO)
                .orElse(null);
    }
}
