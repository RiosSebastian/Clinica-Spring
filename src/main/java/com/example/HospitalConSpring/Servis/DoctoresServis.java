package com.example.HospitalConSpring.Servis;

import com.example.HospitalConSpring.dto.DoctoresDtoRes;
import com.example.HospitalConSpring.dto.req.DoctoresDtoReq;

public interface DoctoresServis {

    // Crear doctor
    DoctoresDtoRes crearDoctores(DoctoresDtoReq DoctoresDtoReq);

    // Actualizar doctor
    DoctoresDtoRes actualizarDoctores(Long id, DoctoresDtoReq DoctoresDtoReq);

    // Eliminar doctor
    void eliminarDoctores(Long id);

    // Buscar doctor por diferentes atributos
    DoctoresDtoRes getByNombreAndApellido(String nombre, String apellido);
    DoctoresDtoRes findByespecialidad(String Especialidad);


}
