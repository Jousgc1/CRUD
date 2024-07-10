package com.certus.edu.pe.servicios;

import com.certus.edu.pe.modelo.Estudiante;
import java.util.List;
import java.util.Optional;


public interface EstudianteService {
    List<Estudiante> findAll();
    Optional<Estudiante> findById(Integer id);
    Estudiante save(Estudiante estudiante);
    void deleteById(Integer id);
    
    
    
}


