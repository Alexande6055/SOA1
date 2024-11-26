package com.gestioPlus.spring.servicie;

import com.gestioPlus.spring.entities.Estudiante;

import java.util.List;

public interface EstudianteService {
    Estudiante crear(Estudiante estudiante);
    Estudiante actualizar(Estudiante estudiante);
    List<Estudiante> obtenerEstudiantes();
    Estudiante obtenerEstudianteCedula(String cedula);
    void eliminar(String cedula);
}
