package com.example.tibackend.service;

import com.example.tibackend.model.Domicilio;
import com.example.tibackend.model.DomicilioDTO;

import java.util.*;

public interface IDomicilioService {

    public void crearDomicilio(DomicilioDTO domicilioDTO);

    public DomicilioDTO consultarDomicilio(Long id);

    public void actualizarDomicilio(DomicilioDTO domicilioDTO);

    public void eliminarDomicilio(Long id);

    public Collection<DomicilioDTO> obtenerTodos();

    public Set<DomicilioDTO> getDomicilioByLocalidadLike(String localidad);
}
