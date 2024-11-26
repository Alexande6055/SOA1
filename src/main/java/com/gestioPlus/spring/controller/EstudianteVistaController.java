package com.gestioPlus.spring.controller;

import com.gestioPlus.spring.entities.Estudiante;
import com.gestioPlus.spring.servicie.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteVistaController {
    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public String listarEstudiantes(Model model) {
        model.addAttribute("estudiantes", estudianteService.obtenerEstudiantes());
        return "lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "formulario";
    }

    @PostMapping("/guardar")
    public String guardarEstudiante(Estudiante estudiante) {
        estudianteService.crear(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/editar/{cedula}")
    public String mostrarFormularioEditar(@PathVariable String cedula, Model model) {
        Estudiante estudiante = estudianteService.obtenerEstudianteCedula(cedula);
        model.addAttribute("estudiante", estudiante);
        return "formulario";
    }

    @GetMapping("/eliminar/{cedula}")
    public String eliminarEstudiante(@PathVariable String cedula){
        estudianteService.eliminar(cedula);
        return "redirect:/estudiantes";
    }
}
