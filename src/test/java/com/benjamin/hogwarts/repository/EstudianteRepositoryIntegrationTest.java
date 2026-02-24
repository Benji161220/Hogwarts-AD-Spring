package com.benjamin.hogwarts.repository;

import com.benjamin.hogwarts.model.Estudiante;
import com.benjamin.hogwarts.model.Mascota;
import com.benjamin.hogwarts.respository.EstudianteRespository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class EstudianteRepositoryIntegrationTest {

    @Autowired
    private EstudianteRespository estudianteRespository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void eliminarEstudiante_DebeEliminarMascotaPorCascada() {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre("Harry");
        estudiante.setApellido("Potter");
        estudiante.setAnyoCurso(2);
        estudiante.setFechaNacimiento(LocalDate.of(1980, 7, 31));

        Mascota mascota = new Mascota();
        mascota.setNombre("Lechuza");
        mascota.setEspecie("Lechuza");
        estudiante.setMascota(mascota);
        mascota.setEstudiante(estudiante);

        Estudiante guardado = estudianteRespository.save(estudiante);
        Long idMascota = guardado.getMascota().getId();

        estudianteRespository.delete(guardado);

        estudianteRespository.flush();
        entityManager.clear();

        assertFalse(estudianteRespository.findById(guardado.getId()).isPresent());

        Mascota mascotaEnBD = entityManager.find(Mascota.class, idMascota);
        assertNull(mascotaEnBD, "La mascota deberia haber sido borrado por la cascada en JPA");
    }
}
