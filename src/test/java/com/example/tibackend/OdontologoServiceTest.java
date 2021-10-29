package com.example.tibackend;

import com.example.tibackend.model.OdontologoDTO;
import com.example.tibackend.service.OdontologoService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;

    @Test
    public void agregarOdontologo() {
        OdontologoDTO odontologoDTO1 = new OdontologoDTO();
        odontologoDTO1.setNombre("Diego");
        odontologoDTO1.setApellido("Leon");
        odontologoDTO1.setMatricula("12345");

        odontologoService.crearOdontologo(odontologoDTO1);

        OdontologoDTO odontologoDTO2 = new OdontologoDTO();
        odontologoDTO2.setNombre("Diego");
        odontologoDTO2.setApellido("Leon");
        odontologoDTO2.setMatricula("12345");
        odontologoService.crearOdontologo(odontologoDTO2);
    }

    @Test
    //Comprobar que exista el id en la tabla de odontólogos antes de probar este test
    public void buscarOdontologo(){
        OdontologoDTO odontologoDTO = odontologoService.consultarOdontologo(1L);
        Assert.assertTrue(odontologoDTO.getId() != null);

    }

    @Test
    //Comprobar que exista el id en la tabla de odontólogos antes de probar este test
    public void borrarOdontologo(){
            odontologoService.eliminarOdontologo(1L);
    }

    @Test
    //Comprobar la cantidad de elementos que tiene la tabla odontólogos antes de probar este test
    public void traerOdontologos(){
        Collection<OdontologoDTO> odontologoDTOList = odontologoService.obtenerTodos();
        Assert.assertTrue(!odontologoDTOList.isEmpty());
        Assert.assertTrue(odontologoDTOList.size() == 1);
        System.out.println(odontologoDTOList);
    }

}
