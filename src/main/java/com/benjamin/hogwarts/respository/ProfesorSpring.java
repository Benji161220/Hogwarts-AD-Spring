package com.benjamin.hogwarts.respository;

import com.benjamin.hogwarts.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorSpring extends JpaRepository<Profesor, Long> {
}
