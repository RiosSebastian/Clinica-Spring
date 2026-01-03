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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EspecialidadesServisImpl implements EspecialidadService {

    private final EspecialidadMapper especialidadMapper;
    private final EspecialidadRepository especialidadRepository;

    public EspecialidadesServisImpl(EspecialidadMapper especialidadMapper,
                                    EspecialidadRepository especialidadRepository) {
        this.especialidadMapper = especialidadMapper;
        this.especialidadRepository = especialidadRepository;
    }

    @Override
    public EspecialidadDtoRes createEspecialidad(EspecialidadDtoReq especialidadDtoReq) {
        Especialidad especialidad  = EspecialidadMapper.toEspecialidad(especialidadDtoReq);
        especialidad = especialidadRepository.save(especialidad);
        return especialidadMapper.toDto(especialidad);
    }

    @Override
    public EspecialidadDtoRes updateEspecialidad(Long id, EspecialidadDtoReq especialidadDtoReq) throws ChangeSetPersister.NotFoundException {
        Especialidad existing = especialidadRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);

        existing.setNombre(especialidadDtoReq.nombre());
        existing.setDescripcion(especialidadDtoReq.descripcion());
        existing.setDoctores(especialidadDtoReq.doctore());

        existing = especialidadRepository.save(existing);
        return especialidadMapper.toDto(existing);
    }

    @Override
    public void deleteEspecialidad(Long id) throws ChangeSetPersister.NotFoundException {
        Especialidad especialidad = especialidadRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
        especialidadRepository.delete(especialidad);
    }

    @Override
    public EspecialidadDtoRes getEspecialidadById(Long id) {
        Especialidad e = especialidadRepository.findById(id).orElse(null);
        return e == null ? null : especialidadMapper.toDto(e);
    }

    @Override
    public List<EspecialidadDtoRes> getAllEspecialidades() {
        return especialidadRepository.findAll().stream()
                .map(especialidadMapper::toDto)
                .collect(Collectors.toList());
    }
}
