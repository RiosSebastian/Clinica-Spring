package com.example.HospitalConSpring.Servis;

import com.example.HospitalConSpring.dto.PacienteDtoRes;
import com.example.HospitalConSpring.entity.Paciente;

import java.util.List;
import java.util.Optional;

public interface ServisPaciente {
    PacienteDtoRes<Paciente> findById (long id);
    List<Paciente> findBynombre(String nombre);

    List<Paciente>findByapellido(String apellido);

    List<Paciente>findBydni (String dni);

    List<Paciente> findByemail (String email);
}
