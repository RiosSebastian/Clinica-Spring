package com.example.HospitalConSpring.dto;

import com.example.HospitalConSpring.entity.Paciente;
import lombok.Builder;
import lombok.NonNull;

import java.util.Date;

@Builder
public record AnalisisDtoRes(
                             String tipo,

                             Date fecha,

                             String archivoUrl,

                             Paciente paciente) {
}
