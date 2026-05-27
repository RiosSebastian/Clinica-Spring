package com.example.HospitalConSpring.dto;

import java.time.LocalDate;

public record TurnoFilterDto(Long pacienteId,
                             Long doctorId,
                             LocalDate fecha,
                             String estado) {
}
