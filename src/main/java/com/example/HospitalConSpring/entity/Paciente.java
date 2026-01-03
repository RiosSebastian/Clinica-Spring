package com.example.HospitalConSpring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

import java.util.List;

@Entity
@Table(name = "paciente")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"analisis", "turnos", "camaActual"})
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String password;
    private String dni;

    private LocalDate fechaNacimiento;

    @Column(unique = true)
    private String email;

    private String telefono;
    private String direccion;
    private String tipoSangre;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("paciente")
    private List<Analisis> analisis;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("paciente")
    private List<Turno> turnos;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cama_actual_id")
    @JsonIgnoreProperties("paciente")
    private Cama camaActual;
}
