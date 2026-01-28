package com.benjamin.hogwarts.service.impl;

import com.benjamin.hogwarts.model.Casa;
import com.benjamin.hogwarts.respository.CasaRepository;
import com.benjamin.hogwarts.service.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CasaServiceImpl implements CasaService {
    private final CasaRepository casaRepository;

    @Autowired
    public CasaServiceImpl(CasaRepository casaRepository) {
        this.casaRepository = casaRepository;
    }

    @Override
    public List<Casa> obtenerTodasCasas() {
        return casaRepository.findAll();
    }

    @Override
    public Casa obtenerCasaPorId(Long id) {
        return casaRepository.findById(id).orElse(null);
    }
}
