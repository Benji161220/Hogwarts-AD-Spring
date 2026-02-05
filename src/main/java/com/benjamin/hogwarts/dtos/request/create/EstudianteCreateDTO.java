package com.benjamin.hogwarts.dtos.request.create;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EstudianteCreateDTO {
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 50, message = "El nombre no puede superar los 50 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(max = 50, message = "El apellido no puede superar los 50 caracteres")
    private String apellido;

    @NotNull(message = "El año del curso no puede ser nulo")
    @Min(value = 0, message = "El año del curso no puede estar por debajo de 0")
    private int anyoCurso;

    @NotNull(message = "La fecha de nacimiento no puede ser nula")
    private LocalDate fechaNacimiento;

    @NotNull(message = "EL id de la casa no puede ser nulo")
    @Min(value = 0, message = "El id de la casa no puede ser negativo")
    private Long casaId;

    @Valid
    @NotNull(message = "La mascota es obligatoria")
    private MascotaCreateDTO mascota;
}
