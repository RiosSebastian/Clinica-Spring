package com.example.HospitalConSpring.dto.req;

import com.example.HospitalConSpring.entity.Paciente;
import lombok.NonNull;

import java.util.Date;

public record AnalisisDtoReq( @NonNull
                              String tipo,
                              @NonNull
                             Date fecha,
                              @NonNull
                             String archivoUrl,
                              @NonNull
                             Paciente paciente) {
}
