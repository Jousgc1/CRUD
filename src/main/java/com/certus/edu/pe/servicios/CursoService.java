package com.certus.edu.pe.servicios;

import com.certus.edu.pe.modelo.Curso;
import com.certus.edu.pe.repositorio.cursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
public class CursoService {

    @Autowired
    private cursoRepositorio cursoRepository;

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }
    
    public Optional<Curso> findById(Integer id) {
        return cursoRepository.findById(id);
    }
    
    
    @Transactional
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Transactional
    public void deleteCurso(Integer idCurso) {
        if (cursoRepository.existsById(idCurso)) {
            cursoRepository.deleteById(idCurso);
        } else {
            throw new EntityNotFoundException("Curso no encontrado con id: " + idCurso);
        }
    }
}
