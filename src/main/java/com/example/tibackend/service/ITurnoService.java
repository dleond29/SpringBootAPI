package com.example.tibackend.service;

import com.example.tibackend.model.Turno;
import com.example.tibackend.model.TurnoDTO;

import java.util.*;

public interface ITurnoService {
    public void crearTurno(TurnoDTO turnoDTO);

    public TurnoDTO consultarTurno(Long id);

    public void actualizarTurno(TurnoDTO turnoDTO);

    public void eliminarTurno(Long id);

    public Collection<TurnoDTO> obtenerTodos();
}
