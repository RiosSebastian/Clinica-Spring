package com.example.HospitalConSpring.mapper;

import com.example.HospitalConSpring.dto.PacienteDtoReq;
import com.example.HospitalConSpring.dto.PacienteDtoRes;
import com.example.HospitalConSpring.entity.Paciente;

public class UserMapper {
    public static PacienteDtoRes toDto(Paciente paciente){
        return PacienteDtoRes.builder()
                .id(paciente.getId())
                .nombre(paciente.getNombre())
                .apellido(paciente.getApellido())
                .dni(paciente.getDni())
                .email(paciente.getEmail())
                .telefono(paciente.getTelefono())
                .fechaNacimiento(paciente.getFechaNacimiento())
                .direccion(paciente.getDireccion())
                .tipoSangre(paciente.getTipoSangre())
                .turnos(paciente.getTurnos())
                .camaActual(paciente.getCamaActual())
                .analisis(paciente.getAnalisis())
                .build();
    }

    public static Paciente toPaciente(PacienteDtoReq request){
        return Paciente.builder()
                .nombre(request.nombre())
                .apellido(request.apellido())
                .dni(request.dni())
                .email(request.email())
                .telefono(request.telefono())
                .fechaNacimiento(request.fechaNacimiento())
                .direccion(request.direccion())
                .tipoSangre(request.tipoSangre())
                .turnos(request.turnos())
                .camaActual(request.camaActual())
                .analisis(request.analisis())
                .build();
    }
}
