package com.example.HospitalConSpring.Servis;

import com.example.HospitalConSpring.dto.TurnoDtoRes;
import com.example.HospitalConSpring.dto.TurnoFilterDto;
import com.example.HospitalConSpring.dto.req.TurnoDtoReq;

import java.util.List;

public interface TurnoServis {
    TurnoDtoRes createTurno(TurnoDtoReq dto);

    TurnoDtoRes updateTurno(Long id, TurnoDtoReq dto);

    void cancelTurno(Long id);

    TurnoDtoRes getTurnoById(Long id);

    List<TurnoDtoRes> getTurnosByPaciente(Long pacienteId);

    List<TurnoDtoRes> getTurnosByDoctor(Long doctorId);

    List<TurnoDtoRes> findTurnos(TurnoFilterDto filter);
}
