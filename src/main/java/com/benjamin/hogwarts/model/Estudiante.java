package com.benjamin.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.SoftDelete;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "estudiante", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"nombre", "apellido"})
})
@SoftDelete
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String apellido;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_casa")
    private Casa casa;

    @Column(name = "anyo_curso", nullable = false)
    private int anyoCurso;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;


    @OneToOne(mappedBy = "estudiante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Mascota mascota;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "estudiante-asignaturas")
    private List<EstudianteAsignatura> asignaturas = new ArrayList<>();

    public String getNombreCompleto(){
        return nombre + " " + apellido;
    }

    public void setNombreCompleto(String nombreCompleto){
        String[] partes = nombreCompleto.split(" ", 2);
        this.nombre = partes[0];
        this.apellido = partes.length > 1 ? partes[1] : "";
    }
}
