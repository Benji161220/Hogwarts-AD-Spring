package com.benjamin.hogwarts.mappers;

import com.benjamin.hogwarts.dtos.response.AsignaturaDTO;
import com.benjamin.hogwarts.model.Asignatura;
import org.springframework.stereotype.Component;

@Component
public class AsignaturaMapper {
    public AsignaturaDTO toDTO(Asignatura asignatura){
        if (asignatura == null){
            return null;
        }
        AsignaturaDTO dto = new AsignaturaDTO();
        dto.setId(asignatura.getId());
        dto.setNombre(asignatura.getNombre());
        dto.setAula(asignatura.getAula());
        dto.setObligatoria(asignatura.isObligatoria());
        dto.setProfesor(asignatura.getProfesor().getNombreCompleto());
        return dto;
    }
}
