package com.benjamin.hogwarts.service;

import com.benjamin.hogwarts.model.Mascota;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MascotaService {
    List<Mascota> obtenerTodasMascotas();

    Mascota obtenerMascotaPorId(Long id);
}
