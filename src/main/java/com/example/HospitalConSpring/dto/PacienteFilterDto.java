package com.example.HospitalConSpring.dto;

public record PacienteFilterDto(        String nombre,
                                        String apellido,
                                        String dni,
                                        String email,
                                        String telefono,
                                        String tipoSangre) {
}
