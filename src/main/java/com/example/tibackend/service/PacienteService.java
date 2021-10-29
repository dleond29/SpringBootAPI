package com.example.tibackend.service;

import com.example.tibackend.model.Paciente;
import com.example.tibackend.model.PacienteDTO;
import com.example.tibackend.repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PacienteService implements IPacienteService{

    @Autowired
    IPacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;

    public void crearPaciente(PacienteDTO pacienteDTO){
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        pacienteRepository.save(paciente);
    }

    public PacienteDTO consultarPaciente(Long id){
        PacienteDTO pacienteDTO = null;
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);
        if(pacienteOptional.isPresent()){
            pacienteDTO = mapper.convertValue(pacienteOptional, PacienteDTO.class);
        }
        return pacienteDTO;
    }

    public void actualizarPaciente(PacienteDTO pacienteDTO){
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        pacienteRepository.save(paciente);
    }

    public void eliminarPaciente(Long id){
        pacienteRepository.deleteById(id);
    }

    public Collection<PacienteDTO> obtenerTodos(){
        List<Paciente> pacienteList = pacienteRepository.findAll();
        Set<PacienteDTO> pacienteDTOSet = new HashSet<>();
        for (Paciente paciente : pacienteList) {
            PacienteDTO pacienteDTO;
            pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
            pacienteDTOSet.add(pacienteDTO);
        }
        return pacienteDTOSet;
    }

    public Set<PacienteDTO> getPacienteByApellidoLike(String apellido){
        Set<Paciente> pacienteSet = pacienteRepository.getPacienteByApellidoLike(apellido);
        Set<PacienteDTO> pacienteDTOSet = new HashSet<>();
        for (Paciente paciente : pacienteSet) {
            PacienteDTO pacienteDTO;
            pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
            pacienteDTOSet.add(pacienteDTO);
        }
        return pacienteDTOSet;
    }
}
