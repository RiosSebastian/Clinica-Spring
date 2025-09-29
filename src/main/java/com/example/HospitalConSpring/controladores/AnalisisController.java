package com.example.HospitalConSpring.controladores;

import com.example.HospitalConSpring.Servis.AnalisisService;
import com.example.HospitalConSpring.dto.AnalisisDtoRes;
import com.example.HospitalConSpring.dto.req.AnalisisDtoReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analisis")
public class AnalisisController {

    private final AnalisisService analisisService;
    private final Logger log = LoggerFactory.getLogger(AnalisisController.class);

    public AnalisisController(AnalisisService analisisService) {
        this.analisisService = analisisService;
    }

    // Obtener análisis por id
    @GetMapping("/{id}")
    public ResponseEntity<AnalisisDtoRes> getAnalisisById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(analisisService.getAnalisisById(id));
        } catch (RuntimeException e) {
            log.warn("Análisis no encontrado con id {}", id);
            return ResponseEntity.notFound().build();
        }
    }

    // Listar análisis de un paciente
    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<AnalisisDtoRes>> getAnalisisByPaciente(@PathVariable Long pacienteId) {
        return ResponseEntity.ok(analisisService.getAnalisisByPaciente(pacienteId));
    }

    // Crear análisis
    @PostMapping
    public ResponseEntity<AnalisisDtoRes> createAnalisis(@RequestBody AnalisisDtoReq dto) {
        log.info("Creando análisis para paciente {}", dto.paciente());
        return ResponseEntity.ok(analisisService.createAnalisis(dto));
    }

    // Eliminar análisis
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnalisis(@PathVariable Long id) {
        try {
            analisisService.deleteAnalisis(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            log.warn("No se pudo eliminar análisis con id {}", id);
            return ResponseEntity.notFound().build();
        }
    }
}
