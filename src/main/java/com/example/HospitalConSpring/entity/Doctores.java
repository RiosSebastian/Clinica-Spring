package com.example.HospitalConSpring.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;


@Entity
@Builder
@Data
@Table(name="doctor")

public class Doctores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String matricula;
    Especialidad especialidad;
    private List<Turno> turnos;
}
