package com.example.HospitalConSpring.dto.req;

import com.example.HospitalConSpring.entity.Paciente;
import com.example.HospitalConSpring.enumm.EstadoTurno;
import jakarta.validation.constraints.NotNull;

import java.sql.Time;
import java.util.Date;

public record TurnoDtoReq(@NotNull
                          Date fecha,
                          @NotNull
                          Time hora,
                          @NotNull
                          Paciente paciente,
                          @NotNull
                          EstadoTurno estado) {
}
