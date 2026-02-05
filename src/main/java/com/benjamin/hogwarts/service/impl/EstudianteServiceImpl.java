package com.benjamin.hogwarts.service.impl;

import com.benjamin.hogwarts.dtos.request.create.EstudianteCreateDTO;
import com.benjamin.hogwarts.dtos.request.update.EstudianteUpdateDTO;
import com.benjamin.hogwarts.dtos.response.EstudianteDTO;
import com.benjamin.hogwarts.mappers.EstudianteMapper;
import com.benjamin.hogwarts.model.Estudiante;
import com.benjamin.hogwarts.respository.CasaRepository;
import com.benjamin.hogwarts.respository.EstudianteRespository;
import com.benjamin.hogwarts.service.EstudianteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EstudianteServiceImpl implements EstudianteService {
    private final EstudianteRespository estudianteRespository;
    private final EstudianteMapper estudianteMapper;
    private final CasaRepository casaRepository;


    @Autowired
    public EstudianteServiceImpl(EstudianteRespository estudianteRespository, EstudianteMapper estudianteMapper, CasaRepository casaRepository) {
        this.estudianteRespository = estudianteRespository;
        this.estudianteMapper = estudianteMapper;
        this.casaRepository = casaRepository;
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
    @Override
    @Transactional
    public EstudianteDTO crearEstudiante(EstudianteCreateDTO dto){
        Estudiante estudiante = estudianteMapper.toEntity(dto);
        estudiante.setCasa(casaRepository.findById(dto.getCasaId())
                .orElseThrow(() -> new NoSuchElementException("Casa no encontrada con id: " + dto.getCasaId())));
        estudiante.getMascota().setEstudiante(estudiante);
        Estudiante estudianteGuardado = estudianteRespository.save(estudiante);
        return estudianteMapper.toDTO(estudianteGuardado);
    }
    @Override
    @Transactional
    public EstudianteDTO actualizarEstudiante(Long id, EstudianteUpdateDTO dto){
        Estudiante estudianteExistente = estudianteRespository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Estudiante no encontrado con id: " + id));
        estudianteMapper.updateEntity(dto, estudianteExistente);
        Estudiante estudianteActualizado = estudianteRespository.save(estudianteExistente);
        return estudianteMapper.toDTO(estudianteActualizado);
    }
}
