package com.certus.edu.pe.repositorio;

import com.certus.edu.pe.modelo.horarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepositorio extends JpaRepository<horarios, Integer> {
}
