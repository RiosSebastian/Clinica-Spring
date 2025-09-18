package com.example.HospitalConSpring.mapper;

import com.example.HospitalConSpring.dto.CamaDtoRes;
import com.example.HospitalConSpring.dto.req.CamaDtoReq;
import com.example.HospitalConSpring.entity.Cama;

public class camaMapper {
    public static CamaDtoRes toDto(Cama cama ){
        return CamaDtoRes.builder()
                .estado(cama.getEstado())
                .numero(cama.getNumero())
                .paciente(cama.getPaciente())
                .build();
    }

    public static Cama toCama(CamaDtoReq request){
        return Cama.builder()
                .estado(request.estado())
                .numero(request.numero())
                .paciente(request.paciente())
                .build();
    }

}
