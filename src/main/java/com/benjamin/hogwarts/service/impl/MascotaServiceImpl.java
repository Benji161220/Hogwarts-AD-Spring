package com.benjamin.hogwarts.service.impl;

import com.benjamin.hogwarts.dtos.response.MascotaDTO;
import com.benjamin.hogwarts.mappers.MascotaMapper;
import com.benjamin.hogwarts.model.Estudiante;
import com.benjamin.hogwarts.model.Mascota;
import com.benjamin.hogwarts.respository.MascotaRepository;
import com.benjamin.hogwarts.service.MascotaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaServiceImpl implements MascotaService {
    private final MascotaRepository mascotaRepository;
    private final MascotaMapper mascotaMapper;

    @Autowired
    public MascotaServiceImpl(MascotaRepository mascotaRepository, MascotaMapper mascotaMapper) {
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

    @Override
    @Transactional
    public void eliminarMascota(Long id){
        Mascota mascota = mascotaRepository.findById(id).orElseThrow(()-> new IllegalStateException("La Mascota con ID " + id + " no existe."));

        Estudiante estudiante = mascota.getEstudiante();

        if (estudiante != null) {
            estudiante.setMascota(null);
            mascota.setEstudiante(null);
        }
        mascotaRepository.delete(mascota);
    }
}
