package com.example.tibackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Domicilios")
@Setter
@Getter

public class Domicilio {
    @Id
    @GeneratedValue
    private Long id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;

}
