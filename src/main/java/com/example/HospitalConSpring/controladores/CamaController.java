package com.example.HospitalConSpring.controladores;

import com.example.HospitalConSpring.Servis.CamaService;
import com.example.HospitalConSpring.dto.CamaDtoRes;
import com.example.HospitalConSpring.dto.req.CamaDtoReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/camas")
public class CamaController {

    private final CamaService camaService;
    private final Logger log = LoggerFactory.getLogger(CamaController.class);

    public CamaController(CamaService camaService) {
        this.camaService = camaService;
    }

    // Obtener cama por id
    @GetMapping("/{id}")
    public ResponseEntity<CamaDtoRes> getCamaById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(camaService.getCamaById(id));
        } catch (RuntimeException e) {
            log.warn("Cama no encontrada con id {}", id);
            return ResponseEntity.notFound().build();
        }
    }

    // Listar todas las camas
    @GetMapping
    public ResponseEntity<List<CamaDtoRes>> getAllCamas() {
        return ResponseEntity.ok(camaService.getAllCamas());
    }

    // Listar camas disponibles
    @GetMapping("/disponibles")
    public ResponseEntity<List<CamaDtoRes>> getCamasDisponibles() {
        return ResponseEntity.ok(camaService.getCamasDisponibles());
    }

    // Crear cama
    @PostMapping
    public ResponseEntity<CamaDtoRes> createCama(@RequestBody CamaDtoReq dto) {
        log.info("Creando nueva cama");
        return ResponseEntity.ok(camaService.createCama(dto));
    }

    // Actualizar cama
    @PutMapping("/{id}")
    public ResponseEntity<CamaDtoRes> updateCama(@PathVariable Long id, @RequestBody CamaDtoReq dto) {
        try {
            return ResponseEntity.ok(camaService.updateCama(id, dto));
        } catch (RuntimeException e) {
            log.warn("No se pudo actualizar cama con id {}", id);
            return ResponseEntity.notFound().build();
        }
    }

    // Liberar cama
    @PutMapping("/{id}/liberar")
    public ResponseEntity<Void> liberarCama(@PathVariable Long id) {
        try {
            camaService.liberarCama(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            log.warn("No se pudo liberar cama con id {}", id);
            return ResponseEntity.notFound().build();
        }
    }
}
