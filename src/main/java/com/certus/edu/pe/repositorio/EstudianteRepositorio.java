package com.certus.edu.pe.repositorio;

import com.certus.edu.pe.modelo.Estudiante;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepositorio extends JpaRepository<Estudiante, Integer> {
	
	@Query("SELECT e FROM Estudiante e WHERE e.estado = 1")
    List<Estudiante> findActiveEstudiantes();
	
	
}
