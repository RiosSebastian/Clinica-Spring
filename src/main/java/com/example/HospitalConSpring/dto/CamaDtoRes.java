package com.example.HospitalConSpring.dto;

import com.example.HospitalConSpring.entity.Paciente;
import com.example.HospitalConSpring.enumm.EstadoCama;
import lombok.Builder;

@Builder
public record CamaDtoRes(
                         String numero,

                         EstadoCama estado,

                         Paciente paciente) {
}
