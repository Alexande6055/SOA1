package com.gestioPlus.spring.repository;

import com.gestioPlus.spring.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante,String> {


}
