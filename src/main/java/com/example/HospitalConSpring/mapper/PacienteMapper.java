package com.example.HospitalConSpring.mapper;

import com.example.HospitalConSpring.dto.req.PacienteDtoReq;
import com.example.HospitalConSpring.dto.PacienteDtoRes;
import com.example.HospitalConSpring.entity.Paciente;


public class PacienteMapper {
    public static PacienteDtoRes toDto(Paciente paciente){
        return PacienteDtoRes.builder()
                .nombre(paciente.getNombre())
                .apellido(paciente.getApellido())
                .dni(paciente.getDni())
                .fechaNacimiento(paciente.getFechaNacimiento())
                .email(paciente.getEmail())
                .telefono(paciente.getTelefono())
                .tipoSangre(paciente.getTipoSangre())
                .build();
    }

    public static Paciente toPaciente(PacienteDtoReq request){
        return Paciente.builder()
                .nombre(request.nombre())
                .apellido(request.apellido())
                .dni(request.dni())
                .fechaNacimiento(request.fechaNacimiento())
                .email(request.email())
                .telefono(request.telefono())
                .tipoSangre(request.tipoSangre())
                .password(request.password()) // si existe
                .build();
    }
}
