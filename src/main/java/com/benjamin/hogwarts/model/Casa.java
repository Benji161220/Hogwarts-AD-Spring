package com.benjamin.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "casa")
public class Casa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_casa")
    private Long id;

    @Column(unique = true, nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String fundador;

    @OneToOne
    @JoinColumn(name = "id_jefe")
    @JsonManagedReference
    private Profesor jefe;

    @Column(nullable = false, length = 50)
    private String fantasma;

    @OneToMany(mappedBy = "casa")
    @JsonManagedReference
    private List<Estudiante> estudiantes;
}
