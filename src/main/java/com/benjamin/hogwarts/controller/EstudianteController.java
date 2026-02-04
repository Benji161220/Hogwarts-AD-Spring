package com.benjamin.hogwarts.controller;

import com.benjamin.hogwarts.dtos.request.create.EstudianteCreateDTO;
import com.benjamin.hogwarts.dtos.response.EstudianteDTO;
import com.benjamin.hogwarts.model.Estudiante;
import com.benjamin.hogwarts.service.EstudianteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<EstudianteDTO>> obtenerTodosLosPerfiles(){
        List<EstudianteDTO> estudiantes = estudianteService.obtenerTodosLosEstudiantes();
        if (estudiantes.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content
        }
        return ResponseEntity.ok(estudiantes);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDTO> obtenerPerfilPorId(@PathVariable Long id) {
        EstudianteDTO estudiante = estudianteService.obtenerEstudiantePorId(id);
        if (estudiante == null) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
        return ResponseEntity.ok(estudiante); // 200 OK
    }
    @PostMapping("/{id}")
    public ResponseEntity<EstudianteDTO> crearEstudiante(@Valid @RequestBody EstudianteCreateDTO dto){
        EstudianteDTO estudianteCreado = estudianteService.crea
    }
}
