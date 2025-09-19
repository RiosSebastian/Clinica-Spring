package com.example.HospitalConSpring.dto;

import com.example.HospitalConSpring.entity.Doctores;
import lombok.Builder;

import java.util.List;

@Builder
public record EspecialidadDtoRes(
         String nombre,
         String descripcion,
         List<Doctores>doctores) {
}
