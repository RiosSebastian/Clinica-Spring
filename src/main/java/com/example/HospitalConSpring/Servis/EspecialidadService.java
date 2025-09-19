package com.example.HospitalConSpring.Servis;

import com.example.HospitalConSpring.dto.EspecialidadDtoRes;
import com.example.HospitalConSpring.dto.req.EspecialidadDtoReq;

import java.util.List;

public interface EspecialidadService {
    EspecialidadDtoRes createEspecialidad(EspecialidadDtoReq dto);

    EspecialidadDtoRes updateEspecialidad(Long id, EspecialidadDtoReq dto);

    void deleteEspecialidad(Long id);

    EspecialidadDtoRes getEspecialidadById(Long id);

    List<EspecialidadDtoRes> getAllEspecialidades();
}
