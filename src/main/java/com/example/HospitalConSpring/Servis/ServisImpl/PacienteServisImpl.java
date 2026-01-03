package com.example.HospitalConSpring.Servis.ServisImpl;

import com.example.HospitalConSpring.Servis.ServisPaciente;
import com.example.HospitalConSpring.dto.PacienteDtoRes;
import com.example.HospitalConSpring.dto.PacienteFilterDto;
import com.example.HospitalConSpring.dto.req.PacienteDtoReq;
import com.example.HospitalConSpring.entity.Paciente;
import com.example.HospitalConSpring.mapper.PacienteMapper;
import com.example.HospitalConSpring.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteServisImpl implements ServisPaciente {

    private final PacienteRepository pacienteRepository;
    private final PacienteMapper pacienteMapper;
    private final PasswordEncoder passwordEncoder;

    public PacienteServisImpl(PacienteRepository pacienteRepository,
                              PacienteMapper pacienteMapper,
                              PasswordEncoder passwordEncoder) {
        this.pacienteRepository = pacienteRepository;
        this.pacienteMapper = pacienteMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public PacienteDtoRes createPaciente(PacienteDtoReq pacienteDtoReq) {
        Paciente paciente = PacienteMapper.toPaciente(pacienteDtoReq);
        if (paciente.getPassword() != null) {
            paciente.setPassword(passwordEncoder.encode(paciente.getPassword()));
        }
        paciente = pacienteRepository.save(paciente);
        return pacienteMapper.toDto(paciente);
    }

    @Override
    public PacienteDtoRes updatePaciente(Long id, PacienteDtoReq pacienteDtoReq) throws ChangeSetPersister.NotFoundException {
        Paciente existing = pacienteRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);

        existing.setNombre(pacienteDtoReq.nombre());
        existing.setApellido(pacienteDtoReq.apellido());
        existing.setDni(pacienteDtoReq.dni());
        existing.setEmail(pacienteDtoReq.email());
        existing.setTelefono(pacienteDtoReq.telefono());
        existing.setFechaNacimiento(pacienteDtoReq.fechaNacimiento());
        existing.setTipoSangre(pacienteDtoReq.tipoSangre());
        // Si querés actualizar password:
        if (pacienteDtoReq.password() != null) {
            existing.setPassword(passwordEncoder.encode(pacienteDtoReq.password()));
        }

        existing = pacienteRepository.save(existing);
        return pacienteMapper.toDto(existing);
    }

    @Override
    public void deletePaciente(Long id) throws ChangeSetPersister.NotFoundException {

    }

    @Override
    public List<PacienteDtoRes> getByNombreAndApellido(String nombre, String apellido) {
        return null;
    }

    @Override
    public List<PacienteDtoRes> getByDni(String dni) {
        return null;
    }

    @Override
    public List<PacienteDtoRes> getByTelefono(String telefono) {
        return null;
    }

    @Override
    public List<PacienteDtoRes> findPacientes(PacienteFilterDto filter) {
        return null;
    }

    // Para los métodos de búsqueda hacé queries en el repo en lugar de findAll()
}

