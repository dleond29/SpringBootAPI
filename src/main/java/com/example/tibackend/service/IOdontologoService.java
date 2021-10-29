package com.example.tibackend.service;

import com.example.tibackend.model.Odontologo;
import com.example.tibackend.model.OdontologoDTO;

import java.util.*;

public interface IOdontologoService {

    public void crearOdontologo(OdontologoDTO odontologoDTO);

    public OdontologoDTO consultarOdontologo(Long id);

    public void actualizarOdontologo(OdontologoDTO odontologoDTO);

    public void eliminarOdontologo(Long id);

    public Collection<OdontologoDTO> obtenerTodos();

    public Set<OdontologoDTO> getOdontologoByApellidoLike(String apellido);

}
