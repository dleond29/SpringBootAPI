package com.example.tibackend.controller;

import com.example.tibackend.model.TurnoDTO;
import com.example.tibackend.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    ITurnoService turnoService;

    @PostMapping
    public ResponseEntity<?> addTurno(@RequestBody TurnoDTO turnoDTO)
    {
        turnoService.crearTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public TurnoDTO getTurno(@PathVariable long id)
    {
        return turnoService.consultarTurno(id);
    }

    @PutMapping()
    public ResponseEntity<?> updateTurno(@RequestBody TurnoDTO turnoDTO)
    {
        turnoService.actualizarTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTurno(@PathVariable long id)
    {
        turnoService.eliminarTurno(id);
        return ResponseEntity.status(HttpStatus.OK).body("eliminado");
    }

    @GetMapping("/list")
    public Collection<TurnoDTO> listTurnos()
    {
        return turnoService.obtenerTodos();
    }
}
