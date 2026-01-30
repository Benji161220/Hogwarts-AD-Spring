package com.benjamin.hogwarts.mappers;

import com.benjamin.hogwarts.dtos.response.AsignaturaCalificacionDTO;
import com.benjamin.hogwarts.dtos.response.EstudianteDTO;
import com.benjamin.hogwarts.model.Estudiante;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class EstudianteMapper {
    private MascotaMapper mascotaMapper;
    private AsignaturaCalificacionMapper asignaturaCalificacionMapper;
    public EstudianteMapper(MascotaMapper mascotaMapper, AsignaturaCalificacionMapper asignaturaCalificacionMapper){
        this.mascotaMapper = mascotaMapper;
        this.asignaturaCalificacionMapper = asignaturaCalificacionMapper;
    }
    public EstudianteDTO toDTO(Estudiante estudiante){
        if (estudiante == null){
            return null;
        }
        EstudianteDTO dto = new EstudianteDTO();
        dto.setId(estudiante.getId());
        dto.setNombre(estudiante.getNombreCompleto());
        dto.setAnyoCurso(estudiante.getAnyoCurso());
        dto.setFechaNacimiento(estudiante.getFechaNacimiento());
        dto.setCasa(estudiante.getCasa().getNombre());
        dto.setMascota(mascotaMapper.toDTO(estudiante.getMascota()));
        dto.setAsignaturas(
                estudiante.getAsignaturas()
                        .stream()
                        .map(asignaturaCalificacionMapper::toDTO)
                        .toList());
        return dto;
    }
}
