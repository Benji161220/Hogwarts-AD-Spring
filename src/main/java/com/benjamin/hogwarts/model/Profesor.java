package com.benjamin.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "profesor", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"nombre", "apellido"})
})
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String apellido;
    @OneToOne
    @JoinColumn(name = "id_asignatura")
    @JsonManagedReference
    private Asignatura asignatura;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @OneToOne(mappedBy = "jefe")
    @JsonBackReference
    private Casa casa;
    public String getNombreCompleto(){
        return nombre + " " + apellido;
    }
}
