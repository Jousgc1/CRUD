package com.certus.edu.pe.servicios;

import com.certus.edu.pe.modelo.Profesor;
import com.certus.edu.pe.repositorio.ProfesorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepositorio profesorRepository;

    public List<Profesor> findAll() {
        return profesorRepository.findAll();
    }

    public Optional<Profesor> findById(Integer id) {
        return profesorRepository.findById(id);
    }

    public  Profesor save(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    public void deleteById(Integer id) {
        profesorRepository.deleteById(id);
    }
    
    public Profesor update(Integer id, Profesor updatedProfesor) {
        return profesorRepository.findById(id)
                .map(profesor -> {
                    profesor.setProfesor_dni(updatedProfesor.getProfesor_dni());
                    profesor.setPrimer_nombre(updatedProfesor.getPrimer_nombre());
                    profesor.setSegundo_nombre(updatedProfesor.getSegundo_nombre());
                    profesor.setApellido_paterno(updatedProfesor.getApellido_paterno());
                    profesor.setApellido_materno(updatedProfesor.getApellido_materno());
                    profesor.setTelefono(updatedProfesor.getTelefono());
                    profesor.setCorreo(updatedProfesor.getCorreo());
                    return profesorRepository.save(profesor);
                })
                .orElseThrow(() -> new RuntimeException("Profesor not found with id " + id));
    }
    
}
