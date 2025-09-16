package com.example.HospitalConSpring.entity;

import com.example.HospitalConSpring.enumm.EstadoCama;
import com.example.HospitalConSpring.enumm.GravedadInternacion;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cama {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private EstadoCama estado;   // (DISPONIBLE, OCUPADA, MANTENIMIENTO)
    private GravedadInternacion gravedad; // (LEVE, MODERADA, GRAVE)
    private Paciente paciente;   // null si está disponible
}
