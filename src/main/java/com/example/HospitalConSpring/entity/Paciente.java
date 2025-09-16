package com.example.HospitalConSpring.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Builder
@Data
@Table(name= "paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaNacimiento;
    private String email;
    private String telefono;
    private String direccion;
    private String tipoSangre;
    private List<Analisis> analisis;
    private List<Turno> turnos;
    private Cama camaActual;
}
