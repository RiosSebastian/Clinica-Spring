package com.example.HospitalConSpring.mapper;

import com.example.HospitalConSpring.dto.EspecialidadDtoRes;
import com.example.HospitalConSpring.dto.req.EspecialidadDtoReq;
import com.example.HospitalConSpring.entity.Especialidad;

public class EspecialidadMapper {
    public EspecialidadDtoRes toDto(Especialidad especialidad){
        return EspecialidadDtoRes.builder()
                .descripcion(especialidad.getDescripcion())
                .doctores(especialidad.getDoctores())
                .nombre(especialidad.getNombre())
                .build();
    }

    public static Especialidad toEspecialidad(EspecialidadDtoReq request){
        return Especialidad.builder()
                .descripcion(request.descripcion())
                .doctores(request.doctore())
                .nombre(request.nombre())
                .build();
    }
}
