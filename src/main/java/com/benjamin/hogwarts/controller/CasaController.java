package com.benjamin.hogwarts.controller;

import com.benjamin.hogwarts.dtos.response.CasaDTO;
import com.benjamin.hogwarts.model.Casa;
import com.benjamin.hogwarts.service.CasaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/casas")
public class CasaController {
    private final CasaService casaService;

    @Autowired
    public CasaController(CasaService casaService) {
        this.casaService = casaService;
    }

    @GetMapping
    @Operation(summary = "Obtiene todos las casas")
    public ResponseEntity<List<CasaDTO>> obtenerTodas() {
        List<CasaDTO> lista = casaService.obtenerTodasCasas();
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene casa por id")
    public ResponseEntity<CasaDTO> obtenerPorId(@PathVariable Long id) {
        CasaDTO casa = casaService.obtenerCasaPorId(id);
        if (casa == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(casa);
    }
}
