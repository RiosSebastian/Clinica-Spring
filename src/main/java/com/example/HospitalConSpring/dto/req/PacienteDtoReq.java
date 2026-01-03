package com.example.HospitalConSpring.dto.req;

import com.example.HospitalConSpring.entity.Analisis;
import com.example.HospitalConSpring.entity.Cama;
import com.example.HospitalConSpring.entity.Turno;
import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


public record PacienteDtoReq(
        @NotBlank String nombre,
        @NotBlank String apellido,
        @NotBlank String password,
        @NotBlank String dni,
        @NotNull LocalDate fechaNacimiento,
        @Email @NotBlank String email,
        @NotBlank String telefono,
        @NotBlank String tipoSangre
        ) {
}
