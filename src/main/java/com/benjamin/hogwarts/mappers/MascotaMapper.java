package com.benjamin.hogwarts.mappers;

import com.benjamin.hogwarts.dtos.request.create.MascotaCreateDTO;
import com.benjamin.hogwarts.dtos.request.update.MascotaUpdateDTO;
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
    public Mascota toEntity(MascotaCreateDTO dto){
        if (dto == null){
            return null;
        }
        Mascota mascota = new Mascota();
        mascota.setNombre(dto.getNombre());
        mascota.setEspecie(dto.getEspecie());
        return mascota;
    }
    public void updateEntityFromDTO(MascotaUpdateDTO dto, Mascota mascota){
        if (dto == null || mascota == null){
            return;
        }
        mascota.setNombre(dto.getNombre());
        mascota.setEspecie(dto.getEspecie());
    }
    public Mascota toEntity(MascotaUpdateDTO dto){
        Mascota mascota = new Mascota();
        mascota.setNombre(dto.getNombre());
        mascota.setEspecie(dto.getEspecie());
        return mascota;
    }
}
