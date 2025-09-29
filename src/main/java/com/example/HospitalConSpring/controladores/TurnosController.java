package com.example.HospitalConSpring.controladores;

import com.example.HospitalConSpring.Servis.TurnoServis;
import com.example.HospitalConSpring.dto.TurnoDtoRes;
import com.example.HospitalConSpring.dto.req.TurnoDtoReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/turnos")
public class TurnosController {

    private final TurnoServis turnoServis;
    private final Logger log = LoggerFactory.getLogger(TurnosController.class);

    public TurnosController(TurnoServis turnoServis) {
        this.turnoServis = turnoServis;
    }

    // Obtener un turno por id
    @GetMapping("/{id}")
    public ResponseEntity<TurnoDtoRes> findOneById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(turnoServis.getTurnoById(id));
        } catch (RuntimeException e) {
            log.warn("Turno no encontrado con id {}", id);
            return ResponseEntity.notFound().build();
        }
    }

    // Crear turno
    @PostMapping
    public ResponseEntity<TurnoDtoRes> create(@RequestBody TurnoDtoReq dto) {
        log.info("Creando turno para paciente {} y doctor {}", dto.paciente(), dto.doctor());
        return ResponseEntity.ok(turnoServis.createTurno(dto));
    }

    // Actualizar turno
    @PutMapping("/{id}")
    public ResponseEntity<TurnoDtoRes> update(@PathVariable Long id, @RequestBody TurnoDtoReq dto) {
        try {
            return ResponseEntity.ok(turnoServis.updateTurno(id, dto));
        } catch (RuntimeException e) {
            log.warn("Error al actualizar turno con id {}", id);
            return ResponseEntity.notFound().build();
        }
    }

    // Cancelar turno
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            turnoServis.cancelTurno(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            log.warn("No se pudo eliminar/cancelar turno con id {}", id);
            return ResponseEntity.notFound().build();
        }
    }

    // Listar turnos por paciente
    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<TurnoDtoRes>> getTurnosByPaciente(@PathVariable Long pacienteId) {
        return ResponseEntity.ok(turnoServis.getTurnosByPaciente(pacienteId));
    }

    // Listar turnos por doctor
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<TurnoDtoRes>> getTurnosByDoctor(@PathVariable Long doctorId) {
        return ResponseEntity.ok(turnoServis.getTurnosByDoctor(doctorId));
    }
}




