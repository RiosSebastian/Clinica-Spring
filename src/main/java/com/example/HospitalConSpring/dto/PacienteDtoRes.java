package com.example.HospitalConSpring.dto;

import com.example.HospitalConSpring.entity.Analisis;
import com.example.HospitalConSpring.entity.Cama;
import com.example.HospitalConSpring.entity.Turno;
import lombok.Builder;

import java.util.Date;
import java.util.List;
@Builder
public record PacienteDtoRes(Long id,
                             String nombre,
                             String apellido,
                             String dni,
                             Date fechaNacimiento,
                             String email,
                             String telefono,
                             String direccion,
                             String tipoSangre,
                             List<Analisis> analisis,
                             List<Turno> turnos,
                             Cama camaActual) {
}
