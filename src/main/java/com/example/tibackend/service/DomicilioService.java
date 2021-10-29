package com.example.tibackend.service;

import com.example.tibackend.model.Domicilio;
import com.example.tibackend.model.DomicilioDTO;
import com.example.tibackend.repository.IDomicilioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DomicilioService implements IDomicilioService{

    @Autowired
    IDomicilioRepository domicilioRepository;

    @Autowired
    ObjectMapper mapper;

    public void crearDomicilio(DomicilioDTO domicilioDTO){
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        domicilioRepository.save(domicilio);
    }

    public DomicilioDTO consultarDomicilio(Long id){
        DomicilioDTO domicilioDTO = null;
        Optional<Domicilio> domicilioOptional = domicilioRepository.findById(id);
        if(domicilioOptional.isPresent()){
            domicilioDTO = mapper.convertValue(domicilioOptional, DomicilioDTO.class);
        }
        return domicilioDTO;
    }

    public void actualizarDomicilio(DomicilioDTO domicilioDTO){
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        domicilioRepository.save(domicilio);
    }

    public void eliminarDomicilio(Long id){
        domicilioRepository.deleteById(id);
    }

    public Collection<DomicilioDTO> obtenerTodos(){
        List<Domicilio> domicilioList = domicilioRepository.findAll();
        Set<DomicilioDTO> domicilioDTOSet = new HashSet<>();
        for (Domicilio domicilio : domicilioList) {
            DomicilioDTO domicilioDTO;
            domicilioDTO = mapper.convertValue(domicilio, DomicilioDTO.class);
            domicilioDTOSet.add(domicilioDTO);
        }
        return domicilioDTOSet;
    }

    public Set<DomicilioDTO> getDomicilioByLocalidadLike(String localidad){
        Set<Domicilio> domicilioSet = domicilioRepository.getDomicilioByLocalidadLike(localidad);
        Set<DomicilioDTO> domicilioDTOSet = new HashSet<>();
        for (Domicilio domicilio : domicilioSet) {
            DomicilioDTO domicilioDTO;
            domicilioDTO = mapper.convertValue(domicilio, DomicilioDTO.class);
            domicilioDTOSet.add(domicilioDTO);
        }
        return domicilioDTOSet;
    }


}
