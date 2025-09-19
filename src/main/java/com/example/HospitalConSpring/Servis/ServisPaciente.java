package com.example.HospitalConSpring.Servis;

import com.example.HospitalConSpring.dto.PacienteDtoRes;
import com.example.HospitalConSpring.dto.PacienteFilterDto;
import com.example.HospitalConSpring.dto.req.PacienteDtoReq;
import com.example.HospitalConSpring.entity.Paciente;

import java.util.List;
import java.util.Optional;

public interface ServisPaciente {

    public interface PacienteService {

        // Crear paciente
        PacienteDtoRes createPaciente(PacienteDtoReq pacienteDtoReq);

        // Actualizar paciente
        PacienteDtoRes updatePaciente(Long id, PacienteDtoReq pacienteDtoReq);

        // Eliminar paciente
        void deletePaciente(Long id);

        // Buscar paciente por diferentes atributos
        PacienteDtoRes getByNombreAndApellido(String nombre, String apellido);
        PacienteDtoRes getByDni(String dni);
        PacienteDtoRes getByTelefono(String telefono);

        // Listar pacientes con filtro
        List<PacienteDtoRes> findPacientes(PacienteFilterDto filter);
    }

}
