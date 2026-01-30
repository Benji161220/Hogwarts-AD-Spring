package com.benjamin.hogwarts.controller;

import com.benjamin.hogwarts.dtos.response.MascotaDTO;
import com.benjamin.hogwarts.model.Mascota;
import com.benjamin.hogwarts.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {
    private final MascotaService mascotaService;

    @Autowired
    public MascotaController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    @GetMapping
    public ResponseEntity<List<MascotaDTO>> obtenerTodas() {
        List<MascotaDTO> lista = mascotaService.obtenerTodasMascotas();
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MascotaDTO> obtenerPorId(@PathVariable Long id) {
        MascotaDTO mascota = mascotaService.obtenerMascotaPorId(id);
        if (mascota == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mascota);
    }
}
