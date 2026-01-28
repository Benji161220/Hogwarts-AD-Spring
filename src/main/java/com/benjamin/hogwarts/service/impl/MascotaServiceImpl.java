package com.benjamin.hogwarts.service.impl;

import com.benjamin.hogwarts.model.Mascota;
import com.benjamin.hogwarts.respository.MascotaSpring;
import com.benjamin.hogwarts.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaServiceImpl implements MascotaService {
    private final MascotaSpring mascotaRepository;

    @Autowired
    public MascotaServiceImpl(MascotaSpring mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    @Override
    public List<Mascota> obtenerTodasMascotas() {
        return mascotaRepository.findAll();
    }

    @Override
    public Mascota obtenerMascotaPorId(Long id) {
        return mascotaRepository.findById(id).orElse(null);
    }
}
