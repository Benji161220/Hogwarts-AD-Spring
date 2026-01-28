package com.benjamin.hogwarts.service.impl;

import com.benjamin.hogwarts.model.Profesor;
import com.benjamin.hogwarts.respository.ProfesorSpring;
import com.benjamin.hogwarts.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService {
    private final ProfesorSpring profesorRepository;

    @Autowired
    public ProfesorServiceImpl(ProfesorSpring profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    @Override
    public List<Profesor> obtenerTodosLosProfesores() {
        return profesorRepository.findAll();
    }

    @Override
    public Profesor obtenerProfesorPorId(Long id) {
        return profesorRepository.findById(id).orElse(null);
    }
}
