package com.benjamin.hogwarts.service.impl;

import com.benjamin.hogwarts.model.Estudiante;
import com.benjamin.hogwarts.respository.EstudianteRespository;
import com.benjamin.hogwarts.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService {
    private final EstudianteRespository estudianteRespository;

    @Autowired
    public EstudianteServiceImpl(EstudianteRespository estudianteRespository) {
        this.estudianteRespository = estudianteRespository;
    }
    @Override
    public List<Estudiante> obtenerTodosLosEstudiantes(){
        return estudianteRespository.findAll();
    }

    @Override
    public Estudiante obtenerEstudiantePorId(Long id) {
        return estudianteRespository.findById(id).orElse(null);
    }
}
