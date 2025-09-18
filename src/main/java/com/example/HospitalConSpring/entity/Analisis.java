package com.example.HospitalConSpring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Entity
@Builder
@Data
public class Analisis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private Date fecha;
    private String archivoUrl;   // para guardar el análisis subido
    private Paciente paciente;
}
