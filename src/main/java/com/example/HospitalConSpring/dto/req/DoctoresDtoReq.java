package com.example.HospitalConSpring.dto.req;

import com.example.HospitalConSpring.entity.Especialidad;
import com.example.HospitalConSpring.entity.Turno;
import lombok.NonNull;

import java.util.List;

public record DoctoresDtoReq(@NonNull
                             String nombre,
                             @NonNull
                             String apellido,
                             @NonNull
                             Especialidad especialidad,
                             List<Turno> turnos) {
}
