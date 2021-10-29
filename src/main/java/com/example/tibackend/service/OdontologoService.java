package com.example.tibackend.service;

import com.example.tibackend.model.Odontologo;
import com.example.tibackend.model.OdontologoDTO;
import com.example.tibackend.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OdontologoService implements IOdontologoService{

    @Autowired
    IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    public void crearOdontologo(OdontologoDTO odontologoDTO){
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
    }

    public OdontologoDTO consultarOdontologo(Long id){
        OdontologoDTO odontologoDTO = null;
        Optional<Odontologo> odontologoOptional = odontologoRepository.findById(id);
        if(odontologoOptional.isPresent()){
            odontologoDTO = mapper.convertValue(odontologoOptional, OdontologoDTO.class);
        }
        return odontologoDTO;
    }

    public void actualizarOdontologo(OdontologoDTO odontologoDTO){
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
    }

    public void eliminarOdontologo(Long id){
        odontologoRepository.deleteById(id);
    }

    public Collection<OdontologoDTO> obtenerTodos(){
        List<Odontologo> odontologoSet = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologoDTOSet = new HashSet<>();
        for (Odontologo odontologo : odontologoSet) {
            OdontologoDTO odontologoDTO;
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
            odontologoDTOSet.add(odontologoDTO);
        }
        return odontologoDTOSet;
    }

    public Set<OdontologoDTO> getOdontologoByApellidoLike(String apellido){
        Set<Odontologo> odontologoSet = odontologoRepository.getOdontologoByApellidoLike(apellido);
        Set<OdontologoDTO> odontologoDTOSet = new HashSet<>();
        for (Odontologo odontologo : odontologoSet) {
            OdontologoDTO odontologoDTO;
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
            odontologoDTOSet.add(odontologoDTO);
        }
        return odontologoDTOSet;
    }
}
