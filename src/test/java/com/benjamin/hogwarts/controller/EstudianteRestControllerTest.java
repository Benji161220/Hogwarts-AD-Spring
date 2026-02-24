package com.benjamin.hogwarts.controller;

import com.benjamin.hogwarts.dtos.request.create.EstudianteCreateDTO;
import com.benjamin.hogwarts.dtos.request.create.MascotaCreateDTO;
import com.benjamin.hogwarts.dtos.response.EstudianteDTO;
import com.benjamin.hogwarts.service.EstudianteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;
import java.time.LocalDate;

import org.springframework.http.MediaType;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EstudianteController.class)
public class EstudianteRestControllerTest {
    @Autowired
    private MockMvc mockMvc; // Para realizar peticiones HTTP

    @MockitoBean
    private EstudianteService estudianteService;

    @Autowired
    private ObjectMapper objectMapper;

    private EstudianteCreateDTO estudianteCreateDTO;
    private EstudianteDTO estudianteResponseDTO;

    @Test
    void createEstudianteConAnyoCursoIgualA10_Error400() throws Exception {
        estudianteCreateDTO = new EstudianteCreateDTO();
        estudianteCreateDTO.setNombre("Harry");
        estudianteCreateDTO.setApellido("Potter");
        estudianteCreateDTO.setAnyoCurso(10);
        estudianteCreateDTO.setFechaNacimiento(LocalDate.of(1980, 7, 31));

        mockMvc.perform(post("/api/estudiantes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(estudianteCreateDTO)))
                .andExpect(status().isNotFound());

        verify(estudianteService, never()).crearEstudiante(any());
    }
}
