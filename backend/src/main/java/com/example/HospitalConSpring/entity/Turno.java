package com.example.HospitalConSpring.entity;

import com.example.HospitalConSpring.enumm.EstadoTurno;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Time;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "turno")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"paciente", "doctor"})
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Usás Date en el proyecto original; mantenemos Date aquí.
    @Temporal(TemporalType.DATE)
    private Date fecha;

    // Hora como java.sql.Time según tu código original
    private Time hora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    @JsonIgnoreProperties("turnos")
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    @JsonIgnoreProperties("turnos")
    private Doctores doctor;

    @Enumerated(EnumType.STRING)
    private EstadoTurno estado;
}

