package com.benjamin.hogwarts.controller;

import com.benjamin.hogwarts.model.EstudianteAsignatura;
import com.benjamin.hogwarts.model.EstudianteAsignaturaId;
import com.benjamin.hogwarts.service.EstudianteAsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estudiante-asignaturas")
public class EstudianteAsignaturaController {
    private final EstudianteAsignaturaService service;

    @Autowired
    public EstudianteAsignaturaController(EstudianteAsignaturaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<EstudianteAsignatura>> obtenerTodas() {
        List<EstudianteAsignatura> lista = service.obtenerTodas();
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{idEstudiante}/{idAsignatura}")
    public ResponseEntity<EstudianteAsignatura> obtenerPorId(@PathVariable Long idEstudiante, @PathVariable Long idAsignatura) {
        EstudianteAsignaturaId id = new EstudianteAsignaturaId(idEstudiante, idAsignatura);
        EstudianteAsignatura ea = service.obtenerPorId(id);
        if (ea == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ea);
    }
}
