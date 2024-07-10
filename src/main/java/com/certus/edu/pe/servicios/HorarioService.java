package com.certus.edu.pe.servicios;

import com.certus.edu.pe.modelo.horarios;
import com.certus.edu.pe.repositorio.HorarioRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepositorio horarioRepository;

    public List<horarios> findAll() {
        return horarioRepository.findAll();
    }

    public Optional<horarios> findById(Integer id) {
        return horarioRepository.findById(id);
    }

    public horarios save(horarios horario) {
        return horarioRepository.save(horario);
    }

    public void deleteById(Integer id) {
        horarioRepository.deleteById(id);
    }
}
