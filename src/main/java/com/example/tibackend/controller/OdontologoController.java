package com.example.tibackend.controller;

import com.example.tibackend.model.OdontologoDTO;
import com.example.tibackend.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    IOdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<?> addOdontologo(@RequestBody OdontologoDTO odontologoDTO)
    {
        odontologoService.crearOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public OdontologoDTO readOdontologo(@PathVariable long id)
    {
        return odontologoService.consultarOdontologo(id);
    }

    @PutMapping()
    public ResponseEntity<?> updateOdontologo(@RequestBody OdontologoDTO odontologoDTO)
    {
        odontologoService.actualizarOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOdontologo(@PathVariable long id)
    {
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.status(HttpStatus.OK).body("eliminado");
    }

    @GetMapping("/list")
    public Collection<OdontologoDTO> listOdontologos()
    {
        return odontologoService.obtenerTodos();
    }

    @GetMapping("/listlastname")
    public Set<OdontologoDTO> listOdontologos(@RequestParam String apellido)
    {
        return odontologoService.getOdontologoByApellidoLike(apellido);
    }


}
