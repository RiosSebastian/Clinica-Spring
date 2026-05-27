package com.example.HospitalConSpring.Servis;

import com.example.HospitalConSpring.dto.PacienteDtoRes;
import com.example.HospitalConSpring.dto.PacienteFilterDto;
import com.example.HospitalConSpring.dto.req.PacienteDtoReq;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface ServisPaciente {

        // Crear paciente
        PacienteDtoRes createPaciente(PacienteDtoReq pacienteDtoReq);

        // Actualizar paciente
        PacienteDtoRes updatePaciente(Long id, PacienteDtoReq pacienteDtoReq) throws ChangeSetPersister.NotFoundException;

        // Eliminar paciente
        void deletePaciente(Long id) throws ChangeSetPersister.NotFoundException;

        // Buscar paciente por diferentes atributos
        List<PacienteDtoRes> getByNombreAndApellido(String nombre, String apellido);
        List<PacienteDtoRes> getByDni(String dni);
        List<PacienteDtoRes> getByTelefono(String telefono);

        // Listar pacientes con filtro
        List<PacienteDtoRes> findPacientes(PacienteFilterDto filter);


}
