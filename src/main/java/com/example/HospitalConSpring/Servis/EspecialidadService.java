package com.example.HospitalConSpring.Servis;

import com.example.HospitalConSpring.dto.EspecialidadDtoRes;
import com.example.HospitalConSpring.dto.req.EspecialidadDtoReq;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface EspecialidadService {
    EspecialidadDtoRes createEspecialidad(EspecialidadDtoReq dto);

    EspecialidadDtoRes updateEspecialidad(Long id, EspecialidadDtoReq dto) throws ChangeSetPersister.NotFoundException;

    void deleteEspecialidad(Long id) throws ChangeSetPersister.NotFoundException;

    EspecialidadDtoRes getEspecialidadById(Long id);

    List<EspecialidadDtoRes> getAllEspecialidades();
}
