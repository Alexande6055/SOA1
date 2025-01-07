package com.gestioPlus.spring.servicie.imp;

import com.gestioPlus.spring.entities.Estudiante;
import com.gestioPlus.spring.repository.EstudianteRepository;
import com.gestioPlus.spring.servicie.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService {
    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
    public Estudiante crear(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante actualizar(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public List<Estudiante> obtenerEstudiantes() {
        List<Estudiante> ts=estudianteRepository.findAll();
        System.out.println(ts.get(0).getCedula());
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante obtenerEstudianteCedula(String cedula) {
        return estudianteRepository.findById(cedula)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void eliminar(String cedula) {
        estudianteRepository.deleteById(cedula);
    }
}
