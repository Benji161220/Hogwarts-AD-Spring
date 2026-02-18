package com.benjamin.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SoftDelete;


@Getter
@Setter
@ToString(exclude = "estudiante")
@EqualsAndHashCode(exclude = "estudiante")
@Entity
@SoftDelete
@Table(name = "mascota")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String especie;

    @OneToOne
    @JoinColumn(name = "id_estudiante", nullable = false)
    @JsonBackReference
    private Estudiante estudiante;
}
