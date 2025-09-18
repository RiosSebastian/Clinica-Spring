package com.example.HospitalConSpring.dto.req;

import com.example.HospitalConSpring.entity.Paciente;
import com.example.HospitalConSpring.enumm.EstadoCama;
import lombok.NonNull;

public record CamaDtoReq(@NonNull
                         String numero,
                         @NonNull
                         EstadoCama estado,
                         @NonNull
                         Paciente paciente) {
}
