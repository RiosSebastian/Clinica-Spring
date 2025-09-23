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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteServisImpl implements ServisPaciente {

    private PacienteRepository pacienteRepository;

    @Autowired
    private PacienteMapper pacienteMapper;

    @Override
    public PacienteDtoRes createPaciente(PacienteDtoReq pacienteDtoReq) {
        Paciente paciente = PacienteMapper.toPaciente(pacienteDtoReq);

        // if (user.getProfileImage() == null || user.getProfileImage().isEmpty()) {
        //     user.setProfileImage("https://res.cloudinary.com/dmwsuzs94/image/upload/v1728906889/user_n1laeq.jpg");
        // }

        // Asegúrate de que estás codificando la contraseña
        paciente.setPassword(passwordEncoder.encode(paciente.getPassword()));

        paciente = pacienteRepository.save(paciente);
        return pacienteMapper.toDto(paciente);
    }

    @Override
    public PacienteDtoRes updatePaciente(Long id, PacienteDtoReq pacienteDtoReq) throws ChangeSetPersister.NotFoundException {//actualizar datos
        Paciente existingUser = pacienteRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        existingUser.setNombre(pacienteDtoReq.nombre());
        existingUser.setPassword(pacienteDtoReq.password());
        existingUser.setEmail(pacienteDtoReq.email());
        existingUser.setUserEnum(Rol.valueOf(pacienteDtoReq.userEnum()));

        existingUser = pacienteRepository.save(existingUser);
        return pacienteMapper.toDto(existingUser);
    }

    @Override
    public void deletePaciente(Long id) throws ChangeSetPersister.NotFoundException {
        Paciente user = pacienteRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        pacienteRepository.delete(user);

    }

    @Override
    public List<PacienteDtoRes> getByNombreAndApellido(String nombre, String apellido) {
        List<Paciente> users = pacienteRepository.findAll();
        return users.stream()
                .map(pacienteMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PacienteDtoRes> getByDni(String dni) {
        List<Paciente> users = pacienteRepository.findAll();
        return users.stream()
                .map(pacienteMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PacienteDtoRes> getByTelefono(String telefono) {
        List<Paciente> users = pacienteRepository.findAll();
        return users.stream()
                .map(pacienteMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PacienteDtoRes> findPacientes(PacienteFilterDto filter) {
        List<Paciente> users = pacienteRepository.findAll();
        return users.stream()
                .map(pacienteMapper::toDto)
                .collect(Collectors.toList());
    }
}
