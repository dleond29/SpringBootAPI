package com.example.tibackend.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Getter @Setter
public class TurnoDTO {
    private Long id;
    private LocalDate fecha;
//    private Time hora;
    private Odontologo odontologo;
    private Paciente paciente;
}
