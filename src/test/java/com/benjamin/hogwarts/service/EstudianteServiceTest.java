package com.benjamin.hogwarts.service;

import com.benjamin.hogwarts.model.Estudiante;
import com.benjamin.hogwarts.model.Mascota;
import com.benjamin.hogwarts.respository.EstudianteRespository;
import com.benjamin.hogwarts.service.impl.EstudianteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EstudianteServiceTest {
    @Mock
    private EstudianteRespository estudianteRespository;
    @InjectMocks
    private EstudianteServiceImpl service;

    private Estudiante estudianteTest;

    private Mascota mascotaTest;

    @BeforeEach
    void setUp() {
        estudianteTest = new Estudiante();
        mascotaTest = new Mascota();
        mascotaTest.setId(1L);
        mascotaTest.setNombre("Flash");
        estudianteTest.setId(1L);
        estudianteTest.setNombre("Pintor");
        estudianteTest.setMascota(mascotaTest);
    }

    @Test
    void eliminarEstudiante_Exito_ConMascota () {

    }
}
