package com.example.HospitalConSpring.entity;

import com.example.HospitalConSpring.enumm.EstadoCama;
import com.example.HospitalConSpring.enumm.GravedadInternacion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "cama")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"paciente"})
public class Cama {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    @Enumerated(EnumType.STRING)
    private EstadoCama estado;

    @Enumerated(EnumType.STRING)
    private GravedadInternacion gravedad;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    @JsonIgnoreProperties({"camaActual", "turnos", "analisis"})
    private Paciente paciente;
}
