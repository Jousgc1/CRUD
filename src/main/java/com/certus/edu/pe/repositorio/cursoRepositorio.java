package com.certus.edu.pe.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.certus.edu.pe.modelo.Curso;

public interface cursoRepositorio extends JpaRepository<Curso, Integer> {
}
