package com.certus.edu.pe.controller;

import com.certus.edu.pe.modelo.Curso;
import com.certus.edu.pe.modelo.Estudiante;
import com.certus.edu.pe.servicios.CursoService;
import com.certus.edu.pe.servicios.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller 
@RequestMapping("/estudiantes")
@CrossOrigin(origins = "http://127.0.0.1:5500") // Reemplaza con el origen de tu frontend
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private CursoService CursoService; 
    
    
    
    
    // Listar todos los estudiantes (para la vista)
    @GetMapping("/listar")
    public String getAllEstudiantes(Model model) {
        List<Estudiante> estudiantes = estudianteService.findAll();
        model.addAttribute("estudiantes", estudiantes);
        return "Estudiante/listadoEstudiantes"; // Asegúrate de tener este archivo HTML
    }

 // Mostrar formulario para agregar un nuevo estudiante
    @GetMapping("/crear")
    public String showCreateForm(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        List<Curso> cursos = CursoService.findAll();
        model.addAttribute("cursos", cursos);
        return "Estudiante/formularioEstudiante";
    }

    // Guardar un nuevo estudiante
    @PostMapping("/guardar")
    public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
        estudianteService.save(estudiante);
        return "redirect:/estudiantes/listar";
    }
    
    // Mostrar formulario para actualizar un estudiante existente
    @GetMapping("/editar/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        Optional<Estudiante> estudiante = estudianteService.findById(id);
        if (estudiante.isPresent()) {
            model.addAttribute("estudiante", estudiante.get());

            // Obtener la lista de cursos y agregarla al modelo
            List<Curso> cursos = CursoService.findAll(); // Asumiendo que tienes un método para obtener todos los cursos
            model.addAttribute("cursos", cursos);

            return "Estudiante/actualizarEstudiante";
        } else {
            return "redirect:/estudiantes/listar";
        }
    }

   

    @PostMapping("/editar")
    public String updateEstudiante(@ModelAttribute Estudiante estudiante) {
        estudianteService.save(estudiante);
        return "redirect:/estudiantes/listar";
    }


    // Confirmar eliminación de estudiante
    @GetMapping("/borrar/{id}")
    public String confirmDelete(@PathVariable Integer id, Model model) {
        Optional<Estudiante> estudiante = estudianteService.findById(id);
        if (estudiante.isPresent()) {
            model.addAttribute("estudiante", estudiante.get());
            return "Estudiante/confirmarEliminarEstudiante";
        } else {
            return "redirect:/estudiantes/listado";
        }
    }

    // Eliminar estudiante (para API REST)
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteEstudiante(@PathVariable Integer id) {
        if (estudianteService.findById(id).isPresent()) {
            estudianteService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
