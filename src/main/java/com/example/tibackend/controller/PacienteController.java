package com.example.tibackend.controller;

import com.example.tibackend.model.OdontologoDTO;
import com.example.tibackend.model.PacienteDTO;
import com.example.tibackend.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    IPacienteService pacienteService;

    @PostMapping
    public ResponseEntity<?> addPaciente(@RequestBody PacienteDTO pacienteDTO)
    {
        pacienteService.crearPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PacienteDTO getPaciente(@PathVariable long id)
    {
        return pacienteService.consultarPaciente(id);
    }

    @PutMapping()
    public ResponseEntity<?> updatePaciente(@RequestBody PacienteDTO pacienteDTO)
    {
        pacienteService.actualizarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePaciente(@PathVariable long id)
    {
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.status(HttpStatus.OK).body("eliminado");
    }

    @GetMapping("/list")
    public Collection<PacienteDTO> listPacientes()
    {
        return pacienteService.obtenerTodos();
    }

    @GetMapping("/listlastname")
    public Set<PacienteDTO> listPacientes(@RequestParam String apellido)
    {
        return pacienteService.getPacienteByApellidoLike(apellido);
    }


}
