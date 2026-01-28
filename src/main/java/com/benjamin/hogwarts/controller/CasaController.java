package com.benjamin.hogwarts.controller;

import com.benjamin.hogwarts.model.Casa;
import com.benjamin.hogwarts.service.CasaService;
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
    public ResponseEntity<List<Casa>> obtenerTodas() {
        List<Casa> lista = casaService.obtenerTodasCasas();
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Casa> obtenerPorId(@PathVariable Long id) {
        Casa casa = casaService.obtenerCasaPorId(id);
        if (casa == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(casa);
    }
}
