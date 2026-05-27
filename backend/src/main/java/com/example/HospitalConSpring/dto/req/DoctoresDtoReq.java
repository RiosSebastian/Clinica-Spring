package com.example.HospitalConSpring.dto.req;


import lombok.NonNull;

import java.util.Date;


public record DoctoresDtoReq(       Long id,
                                    @NonNull String nombre,
                                     @NonNull String apellido,
                                     @NonNull String dni,
                                     @NonNull Date fechaNacimiento,
                                     @NonNull String email,
                                     @NonNull String telefono,
                                     String tipoSangre) {
}
