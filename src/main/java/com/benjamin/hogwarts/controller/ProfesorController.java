package com.benjamin.hogwarts.controller;

import com.benjamin.hogwarts.model.Profesor;
import com.benjamin.hogwarts.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {
    private final ProfesorService profesorService;

    @Autowired
    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @GetMapping
    public ResponseEntity<List<Profesor>> obtenerTodas() {
        List<Profesor> lista = profesorService.obtenerTodosLosProfesores();
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profesor> obtenerPorId(@PathVariable Long id) {
        Profesor profesor = profesorService.obtenerProfesorPorId(id);
        if (profesor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(profesor);
    }
}
