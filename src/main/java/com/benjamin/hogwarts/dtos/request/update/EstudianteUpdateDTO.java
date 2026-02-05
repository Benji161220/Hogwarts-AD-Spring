package com.benjamin.hogwarts.dtos.request.update;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EstudianteUpdateDTO {
    @NotNull(message = "El año del curso no puede ser nulo")
    @Min(value = 0, message = "El año del curso no puede estar por debajo de 0")
    private int anyoCurso;

    @NotNull(message = "La fecha de nacimiento no puede ser nula")
    private LocalDate fechaNacimiento;

    @Valid
    @NotNull(message = "La mascota es obligatoria")
    private MascotaUpdateDTO mascota;
}
