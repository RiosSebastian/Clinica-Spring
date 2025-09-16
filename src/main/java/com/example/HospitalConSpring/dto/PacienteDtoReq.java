package com.example.HospitalConSpring.dto;

import com.example.HospitalConSpring.entity.Analisis;
import com.example.HospitalConSpring.entity.Cama;
import com.example.HospitalConSpring.entity.Turno;
import io.micrometer.common.lang.NonNull;

import java.util.Date;
import java.util.List;

public record PacienteDtoReq(
        @NonNull
         String nombre,
        @NonNull
         String apellido,
        @NonNull
         String dni,
        @NonNull
         Date fechaNacimiento,
        @NonNull
         String email,
        @NonNull
         String telefono,
        @NonNull
         String direccion,
        @NonNull
         String tipoSangre,

         List<Analisis>analisis,

         List<Turno> turnos,
         Cama camaActual) {
}
