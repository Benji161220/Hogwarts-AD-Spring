package com.benjamin.hogwarts.dtos.response;

import lombok.Data;

@Data
public class AsignaturaDTO {
    private Long id;
    private String nombre;
    private String aula;
    private boolean obligatoria;
    private String profesor;
}
