package com.benjamin.hogwarts.dtos.request.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MascotaCreateDTO {
    @NotBlank(message = "El nombre de la mascota no puede estar vacío")
    @Size(max = 50, message = "El nombre de la mascota no puede superar los 50 caracteres")
    private String nombre;

    @NotBlank(message = "La especie no puede estar vacío")
    @Size(max = 50, message = "La especie no puede superar los 50 caracteres")
    private String especie;

    public MascotaCreateDTO(String nombre, String especie) {
        this.nombre = nombre;
        this.especie = especie;
    }
}
