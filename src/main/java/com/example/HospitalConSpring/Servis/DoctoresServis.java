package com.example.HospitalConSpring.Servis;

import com.example.HospitalConSpring.dto.DoctoresDtoRes;
import com.example.HospitalConSpring.dto.PacienteDtoRes;
import com.example.HospitalConSpring.dto.req.DoctoresDtoReq;
import com.example.HospitalConSpring.dto.req.PacienteDtoReq;

public interface DoctoresServis {

    // Crear doctor
    DoctoresDtoRes crearPaciente(DoctoresDtoReq DoctoresDtoReq);

    // Actualizar doctor
    DoctoresDtoRes actualizarPaciente(Long id, DoctoresDtoReq DoctoresDtoReq);

    // Eliminar doctor
    void eliminarDoctores(Long id);

    // Buscar doctor por diferentes atributos
    DoctoresDtoRes getByNombreAndApellido(String nombre, String apellido);
    DoctoresDtoRes getByEspecialidad(String Especialidad);


}
