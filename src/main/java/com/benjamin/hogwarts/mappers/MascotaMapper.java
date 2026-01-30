package com.benjamin.hogwarts.mappers;

import com.benjamin.hogwarts.dtos.response.MascotaDTO;
import com.benjamin.hogwarts.model.Mascota;
import org.springframework.stereotype.Component;

@Component
public class MascotaMapper {
    public MascotaDTO toDTO(Mascota mascota){
        if (mascota == null){
            return null;
        }
        MascotaDTO dto = new MascotaDTO();
        dto.setId(mascota.getId());
        dto.setNombre(mascota.getNombre());
        dto.setEspecie(mascota.getEspecie());
        dto.setEstudiante(mascota.getEstudiante().getNombreCompleto());
        return dto;
    }
}
