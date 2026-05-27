package com.example.HospitalConSpring.Servis;

import com.example.HospitalConSpring.dto.AnalisisDtoRes;
import com.example.HospitalConSpring.dto.req.AnalisisDtoReq;

import java.util.List;

public interface AnalisisService {

    AnalisisDtoRes createAnalisis(AnalisisDtoReq dto);

    void deleteAnalisis(Long id);

    AnalisisDtoRes getAnalisisById(Long id);

    List<AnalisisDtoRes> getAnalisisByPaciente(Long pacienteId);
}
