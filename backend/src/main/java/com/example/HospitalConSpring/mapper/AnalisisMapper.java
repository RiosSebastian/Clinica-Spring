package com.example.HospitalConSpring.mapper;

import com.example.HospitalConSpring.dto.AnalisisDtoRes;
import com.example.HospitalConSpring.dto.req.AnalisisDtoReq;
import com.example.HospitalConSpring.entity.Analisis;

public class AnalisisMapper {
    public static AnalisisDtoRes ToDto(Analisis analisis){
        return AnalisisDtoRes.builder()
                .paciente(analisis.getPaciente())
                .fecha(analisis.getFecha())
                .archivoUrl(analisis.getArchivoUrl())
                .tipo(analisis.getTipo())
                .build();
    }

    public static Analisis ToAnalisis(AnalisisDtoReq request){
        return  Analisis.builder()
                .paciente(request.paciente())
                .fecha(request.fecha())
                .archivoUrl(request.archivoUrl())
                .tipo(request.tipo())
                .build();
    }
}
