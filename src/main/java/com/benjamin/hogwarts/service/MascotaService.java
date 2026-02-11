package com.benjamin.hogwarts.service;

import com.benjamin.hogwarts.dtos.response.MascotaDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MascotaService {
    List<MascotaDTO> obtenerTodasMascotas();

    MascotaDTO obtenerMascotaPorId(Long id);

    @Transactional
    void eliminarMascota(Long id);
}
