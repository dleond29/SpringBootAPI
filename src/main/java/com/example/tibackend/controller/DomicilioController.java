package com.example.tibackend.controller;

import com.example.tibackend.model.DomicilioDTO;
import com.example.tibackend.service.IDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {

    @Autowired
    IDomicilioService domicilioService;

    @PostMapping
    public ResponseEntity<?> addDomicilio(@RequestBody DomicilioDTO domicilioDTO)
    {
        domicilioService.crearDomicilio(domicilioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public DomicilioDTO getDomicilio(@PathVariable long id)
    {
        return domicilioService.consultarDomicilio(id);
    }

    @PutMapping()
    public ResponseEntity<?> updateDomicilio(@RequestBody DomicilioDTO domicilioDTO)
    {
        domicilioService.actualizarDomicilio(domicilioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDomicilio(@PathVariable long id)
    {
        domicilioService.eliminarDomicilio(id);
        return ResponseEntity.status(HttpStatus.OK).body("eliminado");
    }

    @GetMapping("/list")
    public Collection<DomicilioDTO> listDomicilios()
    {
        return domicilioService.obtenerTodos();
    }

    @GetMapping("/listlastname")
    public Set<DomicilioDTO> listDomicilios(@RequestParam String localidad)
    {
        return domicilioService.getDomicilioByLocalidadLike(localidad);
    }

}
