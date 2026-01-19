package com.benjamin.hogwarts.respository;

import com.benjamin.hogwarts.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MascotaSpring extends JpaRepository<Mascota, Long> {
}
