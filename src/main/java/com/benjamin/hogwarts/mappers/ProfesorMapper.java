package com.benjamin.hogwarts.mappers;

import com.benjamin.hogwarts.dtos.response.ProfesorDTO;
import com.benjamin.hogwarts.model.Profesor;
import org.springframework.stereotype.Component;

@Component
public class ProfesorMapper {
    public ProfesorDTO toDTO(Profesor profesor) {
        if (profesor == null){
            return null;
        }
        ProfesorDTO dto = new ProfesorDTO();
        dto.setId(profesor.getId());
        dto.setNombre(profesor.getNombreCompleto());
        dto.setAsignatura(profesor.getAsignatura().getNombre());
        dto.setFechaInicio(profesor.getFechaInicio());
        return dto;
    }
}
