package com.benjamin.hogwarts.mappers;

import com.benjamin.hogwarts.dtos.request.create.EstudianteCreateDTO;
import com.benjamin.hogwarts.dtos.request.update.EstudianteUpdateDTO;
import com.benjamin.hogwarts.dtos.response.EstudianteDTO;
import com.benjamin.hogwarts.model.Estudiante;
import org.springframework.stereotype.Component;



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
    public Estudiante toEntity(EstudianteCreateDTO dto){
        if (dto == null){
            return null;
        }
        Estudiante estudiante = new Estudiante();
        estudiante.setNombreCompleto(dto.getNombre());
        estudiante.setApellido(dto.getApellido());
        estudiante.setAnyoCurso(dto.getAnyoCurso());
        estudiante.setFechaNacimiento(dto.getFechaNacimiento());
        estudiante.setMascota(mascotaMapper.toEntity(dto.getMascota()));
        return estudiante;
    }
    public void updateEntity(EstudianteUpdateDTO dto, Estudiante estudiante){
        if (dto == null || estudiante == null){
            return;
        }
        estudiante.setAnyoCurso(dto.getAnyoCurso());
        estudiante.setFechaNacimiento(dto.getFechaNacimiento());
        mascotaMapper.updateEntityFromDTO(dto.getMascota(), estudiante.getMascota());
    }
}
