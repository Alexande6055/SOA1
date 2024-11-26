package com.gestioPlus.spring.controller;

import com.gestioPlus.spring.entities.Estudiante;
import com.gestioPlus.spring.servicie.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Apiestudiantes")
public class EstudianteController {
    @Autowired
    EstudianteService estudianteService;

    @GetMapping("/buscar")
    public Estudiante getEstudiante(@RequestParam String cedula) {
        return estudianteService.obtenerEstudianteCedula(cedula);
    }
    @GetMapping("/busca/:cedula")
    public Estudiante getEstudiant(@Param("cedula") String cedula) {
        return estudianteService.obtenerEstudianteCedula(cedula);
    }

    @GetMapping
    public List<Estudiante> getEstudiantes() {
        return estudianteService.obtenerEstudiantes();
    }

    @PostMapping
    public Estudiante create(@RequestBody Estudiante estudiante) {
        return estudianteService.crear(estudiante);
    }

    @PutMapping
    public Estudiante actualizar(@RequestBody Estudiante estudiante) {
        return estudianteService.actualizar(estudiante);
    }

    @DeleteMapping
    public void eliminar(@RequestParam String cedula) {
        estudianteService.eliminar(cedula);
    }

}
