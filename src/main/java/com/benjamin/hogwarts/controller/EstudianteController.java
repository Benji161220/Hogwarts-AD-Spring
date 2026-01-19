package com.benjamin.hogwarts.controller;

import com.benjamin.hogwarts.model.Estudiante;
import com.benjamin.hogwarts.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
    private final EstudianteService estudianteService;

    @Autowired
    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }
    @GetMapping
    public ResponseEntity<List<Estudiante>> obtenerTodosLosPerfiles(){
        List<Estudiante> estudiantes = estudianteService.obtenerTodosLosEstudiantes();
        if (estudiantes.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content
        }
        return ResponseEntity.ok(estudiantes);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerPerfilPorId(@PathVariable Long id) {
        Estudiante estudiante = estudianteService.obtenerEstudiantePorId(id);
        if (estudiante == null) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
        return ResponseEntity.ok(estudiante); // 200 OK
    }
}
