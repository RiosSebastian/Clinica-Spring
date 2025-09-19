package com.example.HospitalConSpring.Servis;

import com.example.HospitalConSpring.dto.CamaDtoRes;
import com.example.HospitalConSpring.dto.req.CamaDtoReq;

import java.util.List;

public interface CamaService {
    CamaDtoRes createCama(CamaDtoReq dto);

    CamaDtoRes updateCama(Long id, CamaDtoReq dto);

    void liberarCama(Long id); // marcar como disponible

    CamaDtoRes getCamaById(Long id);

    List<CamaDtoRes> getAllCamas();

    List<CamaDtoRes> getCamasDisponibles();
}
