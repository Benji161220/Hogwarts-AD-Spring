package com.benjamin.hogwarts.service.impl;

import com.benjamin.hogwarts.dtos.response.MascotaDTO;
import com.benjamin.hogwarts.mappers.MascotaMapper;
import com.benjamin.hogwarts.model.Mascota;
import com.benjamin.hogwarts.respository.MascotaSpring;
import com.benjamin.hogwarts.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaServiceImpl implements MascotaService {
    private final MascotaSpring mascotaRepository;
    private final MascotaMapper mascotaMapper;

    @Autowired
    public MascotaServiceImpl(MascotaSpring mascotaRepository, MascotaMapper mascotaMapper) {
        this.mascotaRepository = mascotaRepository;
        this.mascotaMapper = mascotaMapper;
    }

    @Override
    public List<MascotaDTO> obtenerTodasMascotas() {
        return mascotaRepository.findAll().
                stream().
                map(mascotaMapper::toDTO).
                toList();
    }

    @Override
    public MascotaDTO obtenerMascotaPorId(Long id) {
        return mascotaRepository.findById(id).map(mascotaMapper::toDTO).orElse(null);
    }
}
