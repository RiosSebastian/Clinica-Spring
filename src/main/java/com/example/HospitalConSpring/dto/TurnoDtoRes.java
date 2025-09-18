package com.example.HospitalConSpring.dto;

import com.example.HospitalConSpring.entity.Paciente;
import com.example.HospitalConSpring.enumm.EstadoTurno;
import lombok.Builder;

import java.sql.Time;
import java.util.Date;

@Builder
public record TurnoDtoRes( Date fecha,
                             Time hora,
                            Paciente paciente,
                           EstadoTurno estado) {
}
