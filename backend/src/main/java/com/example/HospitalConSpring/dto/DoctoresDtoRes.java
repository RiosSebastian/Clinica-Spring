package com.example.HospitalConSpring.dto;

import com.example.HospitalConSpring.entity.Especialidad;
import com.example.HospitalConSpring.entity.Turno;
import lombok.Builder;

import java.util.List;

@Builder
public record DoctoresDtoRes(  String nombre,
         String apellido,
        Especialidad especialidad,
         List<Turno>turnos) {
}
