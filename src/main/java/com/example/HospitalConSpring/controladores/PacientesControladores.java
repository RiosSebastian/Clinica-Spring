package com.example.HospitalConSpring.controladores;

import com.example.HospitalConSpring.entity.Doctores;
import com.example.HospitalConSpring.entity.Paciente;
import com.example.HospitalConSpring.repository.PacienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PacientesControladores {

    private final PacienteRepository pacienteRepository;
    private final Logger log = LoggerFactory.getLogger(PacientesControladores.class);

    // Constructor
    public PacientesControladores(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    // Buscar paciente por ID
    @GetMapping("api/paciente/{id}")
    public ResponseEntity<Paciente> findOneById(@PathVariable long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if (paciente.isPresent()) { // Usa isPresent() para verificar si el paciente existe
            return ResponseEntity.ok(paciente.get()); // Obtener el objeto Paciente si está presente
        } else {
            return ResponseEntity.notFound().build(); // Retornar 404 si no existe
        }
    }

    // Crear paciente
    @PostMapping("api/nuevopaciente")
    public ResponseEntity<Paciente> create(@RequestBody Paciente paciente, @RequestHeader HttpHeaders headers) {

        // Verificar si el paciente ya tiene ID (lo cual indica que ya existe)
        if (paciente.getId() != null) {
            log.warn("No puedes crear este paciente porque ya existe.");
            return ResponseEntity.badRequest().build();
        }

        // Guardar el nuevo paciente
        Paciente resultado = pacienteRepository.save(paciente);
        return ResponseEntity.ok(resultado);
    }

    // Actualizar paciente
    @PutMapping("api/paciente")
    public ResponseEntity<Paciente> update(@RequestBody Paciente paciente) {

        // Verificar si el paciente tiene un ID (debe existir para ser actualizado)
        if (paciente.getId() == null) {
            log.warn("No puedes actualizar un paciente que no existe.");
            return ResponseEntity.badRequest().build();
        }

        // Verificar si el paciente existe en la base de datos
        if (!pacienteRepository.existsById(paciente.getId())) {
            log.warn("No puedes actualizar un paciente que no existe.");
            return ResponseEntity.notFound().build();
        }

        // Actualizar el paciente
        Paciente resultado = pacienteRepository.save(paciente);
        return ResponseEntity.ok(resultado);
    }

    // Borrar paciente
    @DeleteMapping("/api/paciente/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        // Verificar si el paciente existe antes de eliminarlo
        if (!pacienteRepository.existsById(id)) {
            log.warn("No puedes eliminar un paciente que no existe.");
            return ResponseEntity.notFound().build();
        }

        // Eliminar el paciente
        pacienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

