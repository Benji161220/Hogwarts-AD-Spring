package com.benjamin.hogwarts.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "casa")
public class Casa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_casa")
    private Long id;

    @Column(unique = true)
    private String nombre;

    private String fundador;

    @Column(name = "id_jefe")
    private Integer idJefe;

    private String fantasma;
}
