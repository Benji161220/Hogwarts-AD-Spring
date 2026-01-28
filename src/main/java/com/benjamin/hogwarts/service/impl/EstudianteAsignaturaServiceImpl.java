package com.benjamin.hogwarts.service.impl;

import com.benjamin.hogwarts.model.EstudianteAsignatura;
import com.benjamin.hogwarts.model.EstudianteAsignaturaId;
import com.benjamin.hogwarts.respository.EstudianteAsignaturaRepository;
import com.benjamin.hogwarts.service.EstudianteAsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteAsignaturaServiceImpl implements EstudianteAsignaturaService {
    private final EstudianteAsignaturaRepository repository;

    @Autowired
    public EstudianteAsignaturaServiceImpl(EstudianteAsignaturaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EstudianteAsignatura> obtenerTodas() {
        return repository.findAll();
    }

    @Override
    public EstudianteAsignatura obtenerPorId(EstudianteAsignaturaId id) {
        return repository.findById(id).orElse(null);
    }
}
