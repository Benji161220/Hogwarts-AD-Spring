package com.benjamin.hogwarts.service.impl;

import com.benjamin.hogwarts.dtos.response.AsignaturaDTO;
import com.benjamin.hogwarts.exceptions.GlobalExceptionHandler;
import com.benjamin.hogwarts.mappers.AsignaturaMapper;
import com.benjamin.hogwarts.model.Asignatura;
import com.benjamin.hogwarts.respository.AsignaturaRepository;
import com.benjamin.hogwarts.service.AsignaturaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {
    private final AsignaturaRepository asignaturaRepository;
    private final AsignaturaMapper asignaturaMapper;

    @Autowired
    public AsignaturaServiceImpl(AsignaturaRepository asignaturaRepository, AsignaturaMapper asignaturaMapper) {
        this.asignaturaRepository = asignaturaRepository;
        this.asignaturaMapper = asignaturaMapper;
    }

    @Override
    public List<AsignaturaDTO> obtenerTodasAsignaturas() {
        return asignaturaRepository.findAll().
                stream().
                map(asignaturaMapper::toDTO).
                toList();
    }

    @Override
    public AsignaturaDTO obtenerAsignaturaPorId(Long id) {
        return asignaturaRepository.findById(id).map(asignaturaMapper::toDTO).orElse(null);
    }

    @Override
    @Transactional
    public void eliminarAsignatura(Long id) {
        Asignatura asignatura = asignaturaRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("La asignatura con ID " + id + " no existe."));
        if (!asignatura.getEstudiantesAsignaturas().isEmpty()) {
            throw new GlobalExceptionHandler.ConflictException("No se puede eliminar asignaturas que contengan estudiantes");
        }
        asignaturaRepository.delete(asignatura);
    }
}
