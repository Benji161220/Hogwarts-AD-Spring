package com.benjamin.hogwarts.mappers;

import com.benjamin.hogwarts.dtos.response.CasaDTO;
import com.benjamin.hogwarts.model.Casa;
import com.benjamin.hogwarts.model.Estudiante;
import org.springframework.stereotype.Component;

@Component
public class CasaMapper {
    ProfesorMapper profesorMapper;
    public CasaMapper(ProfesorMapper profesorMapper){
        this.profesorMapper = profesorMapper;
    }
    public CasaDTO toDTO(Casa casa){
        if (casa == null){
            return null;
        }
        CasaDTO dto = new CasaDTO();
        dto.setId(casa.getId());
        dto.setNombre(casa.getNombre());
        dto.setFundador(casa.getFundador());
        dto.setFantasma(casa.getFantasma());
        dto.setJefe(profesorMapper.toDTO(casa.getJefe()));
        dto.setEstudiantes(
                casa.getEstudiantes() != null
                        ? casa.getEstudiantes()
                        .stream()
                        .map(Estudiante::getNombreCompleto)
                        .toList()
                : null);
        return dto;
    }
}
