package com.benjamin.hogwarts.controller;

import com.benjamin.hogwarts.dtos.request.create.EstudianteCreateDTO;
import com.benjamin.hogwarts.dtos.response.EstudianteDTO;
import com.benjamin.hogwarts.exceptions.GlobalExceptionHandler;
import com.benjamin.hogwarts.model.Asignatura;
import com.benjamin.hogwarts.model.EstudianteAsignatura;
import com.benjamin.hogwarts.service.AsignaturaService;
import com.benjamin.hogwarts.service.EstudianteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AsignaturaController.class)
public class AsignaturaRestControllerTest {
    @Autowired
    private MockMvc mockMvc; // Para realizar peticiones HTTP

    @MockitoBean
    private AsignaturaService asignaturaService;

    @BeforeEach
    void setUp() {
        Asignatura asignatura = new Asignatura();
        asignatura.setId(1L);
        asignatura.setNombre("Asignatura");
    }

    @Test
    void eliminarAsignatura_ConEstudiantes_DebeRetornar409() throws Exception {
        doThrow(new GlobalExceptionHandler.ConflictException("No se puede eliminar asignaturas con estudiantes"))
                .when(asignaturaService).eliminarAsignatura(1L);

        mockMvc.perform(delete("/asignaturas/1"))
                .andExpect(status().isConflict());
    }
}
