package com.benjamin.hogwarts.dtos.request.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EstudianteCreateDTO {
    @NotBlank(message = "El nombr no puede estar vacío")
    @Size(max = 50, message = "El nombre no puede superar los 50 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(max = 50, message = "El apellido no puede superar los 50 caracteres")
    private String apellido;

    @NotBlank(message = "El año del curso no puede estar vacío")
    private int anyoCurso;

    @NotBlank(message = "El nombre de usuario no puede estar vacío")
    @Size(max = 50, message = "El nombre de usuario no puede superar los 50 caracteres")
    private LocalDate fechaNacimiento;

    @NotBlank(message = "El nombre de usuario no puede estar vacío")
    @Size(max = 50, message = "El nombre de usuario no puede superar los 50 caracteres")
    private int casaId;

    @NotBlank(message = "El nombre de usuario no puede estar vacío")
    @Size(max = 50, message = "El nombre de usuario no puede superar los 50 caracteres")
    private MascotaCreateDTO mascota;
}
