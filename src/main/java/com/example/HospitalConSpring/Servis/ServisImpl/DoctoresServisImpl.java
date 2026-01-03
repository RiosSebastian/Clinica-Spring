package com.example.HospitalConSpring.Servis.ServisImpl;

import com.example.HospitalConSpring.Servis.DoctoresServis;
import com.example.HospitalConSpring.dto.DoctoresDtoRes;
import com.example.HospitalConSpring.dto.req.DoctoresDtoReq;

public class DoctoresServisImpl implements DoctoresServis {
    @Override
    public DoctoresDtoRes crearDoctores(DoctoresDtoReq DoctoresDtoReq) {
        return null;
    }

    @Override
    public DoctoresDtoRes actualizarDoctores(Long id, DoctoresDtoReq DoctoresDtoReq) {
        return null;
    }

    @Override
    public void eliminarDoctores(Long id) {

    }

    @Override
    public DoctoresDtoRes getByNombreAndApellido(String nombre, String apellido) {
        return null;
    }

    @Override
    public DoctoresDtoRes findByespecialidad(String Especialidad) {
        return null;
    }
}
