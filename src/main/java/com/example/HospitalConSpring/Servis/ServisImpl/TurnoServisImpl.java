package com.example.HospitalConSpring.Servis.ServisImpl;

import com.example.HospitalConSpring.Servis.TurnoServis;
import com.example.HospitalConSpring.dto.TurnoDtoRes;
import com.example.HospitalConSpring.dto.TurnoFilterDto;
import com.example.HospitalConSpring.dto.req.TurnoDtoReq;
import com.example.HospitalConSpring.entity.Doctores;
import com.example.HospitalConSpring.entity.Paciente;
import com.example.HospitalConSpring.entity.Turno;
import com.example.HospitalConSpring.enumm.EstadoTurno;
import com.example.HospitalConSpring.mapper.TurnoMapper;
import com.example.HospitalConSpring.repository.DoctoresRepository;
import com.example.HospitalConSpring.repository.PacienteRepository;
import com.example.HospitalConSpring.repository.TurnoRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TurnoServisImpl implements TurnoServis {

    private final PacienteRepository pacienteRepository;
    private final DoctoresRepository doctoresRepository;
    private final TurnoRepository turnoRepository;
    private final TurnoMapper turnoMapper;

    public TurnoServisImpl(PacienteRepository pacienteRepository,
                           DoctoresRepository doctoresRepository,
                           TurnoRepository turnoRepository,
                           TurnoMapper turnoMapper) {
        this.pacienteRepository = pacienteRepository;
        this.doctoresRepository = doctoresRepository;
        this.turnoRepository = turnoRepository;
        this.turnoMapper = turnoMapper;
    }

    @Override
    public TurnoDtoRes createTurno(TurnoDtoReq dto) {
        Paciente paciente = pacienteRepository.findById(dto.paciente().getId())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        Doctores doctor = doctoresRepository.findById(dto.doctor().getId())
                .orElseThrow(() -> new RuntimeException("Doctor no encontrado"));

        Turno turno = Turno.builder()
                .fecha(dto.fecha())
                .hora(dto.hora())
                .paciente(paciente)
                .doctor(doctor)
                .estado(EstadoTurno.RESERVADO)
                .build();

        turno = turnoRepository.save(turno);
        return turnoMapper.toDto(turno);
    }

    @Override
    public TurnoDtoRes updateTurno(Long id, TurnoDtoReq dto) {
        Turno turno = turnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turno no encontrado"));

        Paciente paciente = pacienteRepository.findById(dto.paciente().getId())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        Doctores doctor = doctoresRepository.findById(dto.doctor().getId())
                .orElseThrow(() -> new RuntimeException("Doctor no encontrado"));

        turno.setFecha(dto.fecha());
        turno.setHora(dto.hora());
        turno.setPaciente(paciente);
        turno.setDoctor(doctor);

        return turnoMapper.toDto(turnoRepository.save(turno));
    }

    @Override
    public void cancelTurno(Long id) {
        Turno turno = turnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turno no encontrado"));

        turno.setEstado(EstadoTurno.CANCELADO);
        turnoRepository.save(turno);
    }

    @Override
    public TurnoDtoRes getTurnoById(Long id) {
        Turno turno = turnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turno no encontrado"));

        return turnoMapper.toDto(turno);
    }

    @Override
    public List<TurnoDtoRes> getTurnosByPaciente(Long pacienteId) {
        return turnoRepository.findAll().stream()
                .filter(t -> t.getPaciente() != null && t.getPaciente().getId().equals(pacienteId))
                .map(turnoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TurnoDtoRes> getTurnosByDoctor(Long doctorId) {
        return turnoRepository.findAll().stream()
                .filter(t -> t.getDoctor() != null && t.getDoctor().getId().equals(doctorId))
                .map(turnoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TurnoDtoRes> findTurnos(TurnoFilterDto filter) {
        Specification<Turno> spec = Specification.where((Specification<Turno>) null);

        if (filter.pacienteId() != null) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(root.get("paciente").get("id"), filter.pacienteId()));
        }
        if (filter.doctorId() != null) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(root.get("doctor").get("id"), filter.doctorId()));
        }
        if (filter.fecha() != null) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(root.get("fecha"), java.sql.Date.valueOf(filter.fecha())));
        }
        if (filter.estado() != null) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(root.get("estado"), EstadoTurno.valueOf(filter.estado())));
        }

        return turnoRepository.findAll(spec).stream()
                .map(turnoMapper::toDto)
                .collect(Collectors.toList());
    }
}


