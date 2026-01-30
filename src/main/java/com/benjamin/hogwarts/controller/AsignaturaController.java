package com.benjamin.hogwarts.controller;

import com.benjamin.hogwarts.dtos.response.AsignaturaDTO;
import com.benjamin.hogwarts.model.Asignatura;
import com.benjamin.hogwarts.model.Estudiante;
import com.benjamin.hogwarts.respository.AsignaturaRepository;
import com.benjamin.hogwarts.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/asignaturas")
public class AsignaturaController {
    private final AsignaturaService asignaturaService;

    @Autowired
    public AsignaturaController(AsignaturaService asignaturaService) {
        this.asignaturaService = asignaturaService;
    }

    @GetMapping
    public ResponseEntity<List<AsignaturaDTO>> obtenerTodas() {
        List<AsignaturaDTO> asignaturas = asignaturaService.obtenerTodasAsignaturas();
        if (asignaturas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(asignaturas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsignaturaDTO> obtenerPorId(@PathVariable Long id) {
        AsignaturaDTO asignatura = asignaturaService.obtenerAsignaturaPorId(id);
        if (asignatura == null) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
        return ResponseEntity.ok(asignatura); // 200 OK
    }
}
