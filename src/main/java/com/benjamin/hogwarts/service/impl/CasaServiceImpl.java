package com.benjamin.hogwarts.service.impl;

import com.benjamin.hogwarts.dtos.response.CasaDTO;
import com.benjamin.hogwarts.mappers.CasaMapper;
import com.benjamin.hogwarts.model.Casa;
import com.benjamin.hogwarts.respository.CasaRepository;
import com.benjamin.hogwarts.service.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CasaServiceImpl implements CasaService {
    private final CasaRepository casaRepository;
    private final CasaMapper casaMapper;

    @Autowired
    public CasaServiceImpl(CasaRepository casaRepository, CasaMapper casaMapper) {
        this.casaRepository = casaRepository;
        this.casaMapper = casaMapper;
    }

    @Override
    public List<CasaDTO> obtenerTodasCasas() {
        return casaRepository.findAll().
                stream().
                map(casaMapper::toDTO).
                toList();
    }

    @Override
    public CasaDTO obtenerCasaPorId(Long id) {
        return casaRepository.findById(id).map(casaMapper::toDTO).orElse(null);
    }
}
