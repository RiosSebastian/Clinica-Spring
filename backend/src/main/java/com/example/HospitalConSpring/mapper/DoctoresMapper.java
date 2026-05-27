package com.example.HospitalConSpring.mapper;

import com.example.HospitalConSpring.dto.DoctoresDtoRes;
import com.example.HospitalConSpring.dto.req.DoctoresDtoReq;
import com.example.HospitalConSpring.entity.Doctores;

public class DoctoresMapper {
    public static DoctoresDtoRes toDto(Doctores doctores){
        return DoctoresDtoRes.builder()
                .nombre(doctores.getNombre())
                .especialidad(doctores.getEspecialidad())
                .turnos(doctores.getTurnos())
                .build();
    }

    public static Doctores toDoctores(DoctoresDtoReq doctoresDtoReq){
        return Doctores.builder()
                .nombre(doctoresDtoReq.nombre())
                .especialidad(doctoresDtoReq.especialidad())
                .turnos(doctoresDtoReq.turnos())
                .build();
    }
}
