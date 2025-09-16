package com.example.HospitalConSpring.entity;

import com.example.HospitalConSpring.enumm.EstadoTurno;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Time;
import java.util.Date;

@Entity
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha;
    private Time hora;
    Paciente paciente;
    private Doctores doctor;
    EstadoTurno estado;  // (RESERVADO, CANCELADO, COMPLETADO)
}
