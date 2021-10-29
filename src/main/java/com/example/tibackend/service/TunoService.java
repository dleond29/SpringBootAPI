package com.example.tibackend.service;

import com.example.tibackend.model.Turno;
import com.example.tibackend.model.TurnoDTO;
import com.example.tibackend.repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TunoService implements ITurnoService {

    @Autowired
    ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;

    public void crearTurno(TurnoDTO turnoDTO){
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        turnoRepository.save(turno);
    }

    public TurnoDTO consultarTurno(Long id){
        TurnoDTO turnoDTO = null;
        Optional<Turno> turnoOptional = turnoRepository.findById(id);
        if(turnoOptional.isPresent()){
            turnoDTO = mapper.convertValue(turnoOptional, TurnoDTO.class);
        }
        return turnoDTO;
    }

    public void actualizarTurno(TurnoDTO turnoDTO){
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        turnoRepository.save(turno);
    }

    public void eliminarTurno(Long id){
        turnoRepository.deleteById(id);
    }

    public Collection<TurnoDTO> obtenerTodos(){
        List<Turno> turnoList = turnoRepository.findAll();
        Set<TurnoDTO> turnoDTOSet = new HashSet<>();
        for (Turno turno : turnoList) {
            TurnoDTO turnoDTO;
            turnoDTO = mapper.convertValue(turno, TurnoDTO.class);
            turnoDTOSet.add(turnoDTO);
        }
        return turnoDTOSet;
    }

}
