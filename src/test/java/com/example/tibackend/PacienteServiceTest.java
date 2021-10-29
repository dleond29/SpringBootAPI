package com.example.tibackend;

import com.example.tibackend.model.DomicilioDTO;
import com.example.tibackend.model.Paciente;
import com.example.tibackend.model.PacienteDTO;
import com.example.tibackend.service.DomicilioService;
import com.example.tibackend.service.PacienteService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Collection;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class PacienteServiceTest {

    @Autowired
    private PacienteService pacienteService;

    @Test
    public void agregarPaciente() {
//        DomicilioDTO domicilioDTO = new DomicilioDTO();
//        domicilioDTO.setCalle("Falsa");
//        domicilioDTO.setNumero("1239");
//        domicilioDTO.setLocalidad("San Juan");
//        domicilioDTO.setProvincia("Santander");

        PacienteDTO pacienteDTO1 = new PacienteDTO();
        pacienteDTO1.setNombre("Diego");
        pacienteDTO1.setApellido("Leon");
        pacienteDTO1.setDni("12345");
        pacienteDTO1.setFechaRegistro(LocalDate.now());
//        pacienteDTO1.setDomicilio(pacienteDTO1.getDomicilio());
//        pacienteDTO1.setDomicilioDTO(new DomicilioDTO());
        pacienteService.crearPaciente(pacienteDTO1);

    }

    @Test
    //Comprobar que exista el id en la tabla de pacientes antes de probar este test
    public void buscarPaciente(){
        PacienteDTO pacienteDTO = pacienteService.consultarPaciente(7L);
        Assert.assertTrue(pacienteDTO.getId() != null);

    }

    @Test
    //Comprobar que exista el id en la tabla de pacientes antes de probar este test
    public void borrarPaciente(){
        pacienteService.eliminarPaciente(11L);
    }


    @Test
    //Comprobar la cantidad de elementos que tiene la tabla pacientes antes de probar este test
    public void traerPacientes(){
        Collection<PacienteDTO> pacienteDTOCollection = pacienteService.obtenerTodos();
        Assert.assertTrue(!pacienteDTOCollection.isEmpty());
        Assert.assertTrue(pacienteDTOCollection.size() == 8);
        System.out.println(pacienteDTOCollection);
    }
}
