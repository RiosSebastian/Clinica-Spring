package com.example.HospitalConSpring.dto;

import lombok.Builder;

import java.time.LocalDate;


@Builder
public record PacienteDtoRes(
                             String nombre,
                             String apellido,
                             String dni,
                             LocalDate fechaNacimiento,
                             String email,
                             String telefono,

                             String tipoSangre
                             ) {
}
