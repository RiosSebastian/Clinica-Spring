package com.example.HospitalConSpring.dto.req;

import com.example.HospitalConSpring.entity.Doctores;

import java.util.List;

public record EspecialidadDtoReq(String nombre,
                                 String descripcion,
                                 List<Doctores> doctore) {
}
