package com.benjamin.hogwarts.controller;

import com.benjamin.hogwarts.dtos.response.MascotaDTO;
import com.benjamin.hogwarts.model.Mascota;
import com.benjamin.hogwarts.service.MascotaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @Operation(summary = "Obtiene todos las mascotas")
    public ResponseEntity<List<MascotaDTO>> obtenerTodas() {
        List<MascotaDTO> lista = mascotaService.obtenerTodasMascotas();
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene mascota por su id")
    public ResponseEntity<MascotaDTO> obtenerPorId(@PathVariable Long id) {
        MascotaDTO mascota = mascotaService.obtenerMascotaPorId(id);
        if (mascota == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mascota);
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina una mascota por su id")
    public ResponseEntity<Void> eliminarMascota(@PathVariable Long id) {
        mascotaService.eliminarMascota(id);
        return ResponseEntity.noContent().build(); //204 No Content
    }
}
