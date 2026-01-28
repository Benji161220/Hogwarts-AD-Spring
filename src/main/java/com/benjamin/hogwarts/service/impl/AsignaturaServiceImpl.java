package com.benjamin.hogwarts.service.impl;

import com.benjamin.hogwarts.model.Asignatura;
import com.benjamin.hogwarts.respository.AsignaturaRepository;
import com.benjamin.hogwarts.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {
    private final AsignaturaRepository asignaturaRepository;

    @Autowired
    public AsignaturaServiceImpl(AsignaturaRepository asignaturaRepository) {
        this.asignaturaRepository = asignaturaRepository;
    }

    @Override
    public List<Asignatura> obtenerTodasAsignaturas() {
        return asignaturaRepository.findAll();
    }

    @Override
    public Asignatura obtenerAsignaturaPorId(Long id) {
        return asignaturaRepository.findById(id).orElse(null);
    }
}
