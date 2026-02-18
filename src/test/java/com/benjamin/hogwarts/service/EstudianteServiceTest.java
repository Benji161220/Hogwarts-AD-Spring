package com.benjamin.hogwarts.service;

import com.benjamin.hogwarts.model.Estudiante;
import com.benjamin.hogwarts.model.Mascota;
import com.benjamin.hogwarts.respository.EstudianteRespository;
import com.benjamin.hogwarts.respository.MascotaRepository;
import com.benjamin.hogwarts.service.impl.EstudianteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EstudianteServiceTest {
    @Mock
    private EstudianteRespository estudianteRespository;

    @Mock
    private MascotaRepository mascotaRepository;

    @InjectMocks
    private EstudianteServiceImpl estudianteService;


    private Estudiante estudianteTest;

    private Mascota mascotaTest;


    @BeforeEach
    void setUp() {
        estudianteTest = new Estudiante();
        mascotaTest = new Mascota();
        estudianteTest.setId(1L);
        estudianteTest.setNombre("Harry");
        estudianteTest.setApellido("Potter");
        estudianteTest.setMascota(new Mascota());
    }

    @Test
    void eliminarEstudiante_Exito_ConMascota () {
        Long id = 1L;
        when(estudianteRespository.findById(id)).thenReturn(Optional.of(estudianteTest));

        estudianteService.eliminarEstudiante(id);

        verify(mascotaRepository, times(1)).delete(estudianteTest.getMascota());
        verify(estudianteRespository, times(1)).delete(estudianteTest);
    }
}
