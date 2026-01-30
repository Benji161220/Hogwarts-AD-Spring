package com.benjamin.hogwarts.mappers;

import com.benjamin.hogwarts.dtos.response.AsignaturaCalificacionDTO;
import com.benjamin.hogwarts.model.EstudianteAsignatura;
import org.springframework.stereotype.Component;

@Component
public class AsignaturaCalificacionMapper {
    public AsignaturaCalificacionDTO toDTO(EstudianteAsignatura estudianteAsignatura){
        if (estudianteAsignatura == null){
            return null;
        }
        AsignaturaCalificacionDTO dto = new AsignaturaCalificacionDTO();
        dto.setAsignatura(estudianteAsignatura.getAsignatura().getNombre());
        dto.setCalificacion(
                estudianteAsignatura.getCalificacion() != null
                ? estudianteAsignatura.getCalificacion().doubleValue()
                        : 0.0
        );
        return dto;
    }
}
