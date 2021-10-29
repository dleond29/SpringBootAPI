package com.example.tibackend.service;

import com.example.tibackend.model.Paciente;
import com.example.tibackend.model.PacienteDTO;

import java.util.*;

public interface IPacienteService {

    public void crearPaciente(PacienteDTO pacienteDTO);

    public PacienteDTO consultarPaciente(Long id);

    public void actualizarPaciente(PacienteDTO pacienteDTO);

    public void eliminarPaciente(Long id);

    public Collection<PacienteDTO> obtenerTodos();

    public Set<PacienteDTO> getPacienteByApellidoLike(String apellido);
}
