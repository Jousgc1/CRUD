package com.certus.edu.pe.repositorio;

import com.certus.edu.pe.modelo.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepositorio extends JpaRepository<Profesor, Integer> {
}
