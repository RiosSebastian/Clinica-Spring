package com.example.HospitalConSpring.Servis.ServisImpl;

import com.example.HospitalConSpring.Servis.EspecialidadService;
import com.example.HospitalConSpring.dto.EspecialidadDtoRes;
import com.example.HospitalConSpring.dto.req.EspecialidadDtoReq;
import com.example.HospitalConSpring.entity.Especialidad;
import com.example.HospitalConSpring.entity.Paciente;
import com.example.HospitalConSpring.mapper.EspecialidadMapper;
import com.example.HospitalConSpring.mapper.PacienteMapper;
import com.example.HospitalConSpring.repository.EspecialidadRepository;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.stream.Collectors;

public class EspecialidadesServisImpl implements EspecialidadService {

    private EspecialidadMapper especialidadMapper;

    private EspecialidadRepository especialidadRepository;
    @Override
    public EspecialidadDtoRes createEspecialidad(EspecialidadDtoReq especialidadDtoReq) {
        Especialidad especialidad  = PacienteMapper.toPaciente(especialidadDtoReq);
        especialidad = especialidadRepository.save(especialidad);
        return especialidadMapper.toDto(especialidad);
    }

    @Override
    public EspecialidadDtoRes updateEspecialidad(Long id, EspecialidadDtoReq especialidadDtoReq) throws ChangeSetPersister.NotFoundException {
        Especialidad existingEspecialidad= especialidadRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        existingEspecialidad.setNombre(especialidadDtoReq.nombre());
        existingEspecialidad.getDescripcion(especialidadDtoReq.descripcion());
        existingEspecialidad.getDoctores(especialidadDtoReq.doctore());


        existingEspecialidad = especialidadRepository.save(existingEspecialidad);
        return especialidadMapper.toDto(existingEspecialidad);
    }

    @Override
    public void deleteEspecialidad(Long id) throws ChangeSetPersister.NotFoundException {
        Especialidad especialidad = especialidadRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        especialidadRepository.delete(especialidad);
    }

    @Override
    public EspecialidadDtoRes getEspecialidadById(Long id) {
        return null;
    }

    @Override
    public List<EspecialidadDtoRes> getAllEspecialidades() {
        List<Especialidad> users = especialidadRepository.findAll();
        return users.stream()
                .map(especialidadMapper::toDto)
                .collect(Collectors.toList());
    }
}
