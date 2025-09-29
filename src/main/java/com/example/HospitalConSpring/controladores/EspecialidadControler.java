package com.example.HospitalConSpring.controladores;

import com.example.HospitalConSpring.entity.Especialidad;
import com.example.HospitalConSpring.entity.Paciente;
import com.example.HospitalConSpring.repository.EspecialidadRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EspecialidadControler {

    private final EspecialidadRepository especialidadRepository;

    private final Logger log = LoggerFactory.getLogger(EspecialidadControler.class);

    public EspecialidadControler(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    @GetMapping("api/especialidad/{id}")
    public ResponseEntity<Especialidad> findOneById(@PathVariable long id) {
        Optional<Especialidad> especialidad = especialidadRepository.findById(id);
        if (especialidad.isPresent()) { // Usa isPresent() para verificar si el paciente existe
            return ResponseEntity.ok(especialidad.get()); // Obtener el objeto Paciente si está presente
        } else {
            return ResponseEntity.notFound().build(); // Retornar 404 si no existe
        }
    }

    @PostMapping("api/nuevopaciente")
    public ResponseEntity<Especialidad> create(@RequestBody Especialidad especialidad, @RequestHeader HttpHeaders headers) {

        // Verificar si el paciente ya tiene ID (lo cual indica que ya existe)
        if (especialidad.getId() != null) {
            log.warn("No puedes crear este paciente porque ya existe.");
            return ResponseEntity.badRequest().build();
        }

        // Guardar el nuevo paciente
        Especialidad resultado = especialidadRepository.save(especialidad);
        return ResponseEntity.ok(especialidad);
    }

    @PutMapping("api/especialidad")
    public ResponseEntity<Especialidad> update(@RequestBody Especialidad especialidad) {

        // Verificar si el paciente tiene un ID (debe existir para ser actualizado)
        if (especialidad.getId() == null) {
            log.warn("No puedes actualizar un paciente que no existe.");
            return ResponseEntity.badRequest().build();
        }

        // Verificar si el paciente existe en la base de datos
        if (!especialidadRepository.existsById(especialidad.getId())) {
            log.warn("No puedes actualizar un paciente que no existe.");
            return ResponseEntity.notFound().build();
        }

        // Actualizar el paciente
        Especialidad resultado = especialidadRepository.save(especialidad);
        return ResponseEntity.ok(resultado);
    }

    // Borrar paciente
    @DeleteMapping("/api/paciente/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        // Verificar si el paciente existe antes de eliminarlo
        if (!especialidadRepository.existsById(id)) {
            log.warn("No puedes eliminar una especialidad que no existe.");
            return ResponseEntity.notFound().build();
        }

        // Eliminar el paciente
        especialidadRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
