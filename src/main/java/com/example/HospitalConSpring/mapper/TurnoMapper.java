package com.example.HospitalConSpring.mapper;

import com.example.HospitalConSpring.dto.TurnoDtoRes;
import com.example.HospitalConSpring.dto.req.TurnoDtoReq;
import com.example.HospitalConSpring.entity.Turno;

public class TurnoMapper {
    public TurnoDtoRes toDto(Turno turno){
        return TurnoDtoRes.builder()
                .estado(turno.getEstado())
                .paciente(turno.getPaciente())
                .fecha(turno.getFecha())
                .hora(turno.getHora())
                .build();
    }

    public static Turno toTurno(TurnoDtoReq request){
        return Turno.builder()
                .doctor(request.doctor())
                .estado(request.estado())
                .hora(request.hora())
                .fecha(request.fecha())
                .paciente(request.paciente())
                .build();
    }

}
