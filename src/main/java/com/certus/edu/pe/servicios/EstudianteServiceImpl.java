package com.certus.edu.pe.servicios;

import com.certus.edu.pe.modelo.Estudiante;
import com.certus.edu.pe.repositorio.EstudianteRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteRepositorio estudianteRepository;

    @Override
    public List<Estudiante> findAll() {
        return estudianteRepository.findAll(); // Para listar todos los estudiantes
    }


    @Override
    public Optional<Estudiante> findById(Integer id) {
        return estudianteRepository.findById(id);
    }

    @Override
    public Estudiante save(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public void deleteById(Integer id) {
        estudianteRepository.deleteById(id);
    }
    
   
}
