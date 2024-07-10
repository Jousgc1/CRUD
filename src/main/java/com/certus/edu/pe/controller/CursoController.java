package com.certus.edu.pe.controller;

import com.certus.edu.pe.modelo.Curso;
import com.certus.edu.pe.servicios.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping("/listar")
    public String listCursos(Model model) {
        List<Curso> cursos = cursoService.findAll();
        model.addAttribute("cursos", cursos);
        return "Curso/listarCursos"; // Nombre de la plantilla Thymeleaf
    }
    
    @GetMapping("/crear")
    public String createCursoForm(Model model) {
        // Crea un nuevo objeto Curso para el formulario
        model.addAttribute("curso", new Curso());
        return "Curso/crearCurso"; // Nombre de la plantilla Thymeleaf para el formulario de creación
    }

    
    

    @GetMapping("/editar/{id}")
    public String editCurso(@PathVariable Integer id, Model model) {
        Optional<Curso> curso = cursoService.findById(id);
        if (curso.isPresent()) {
            model.addAttribute("curso", curso.get());
            return "Curso/editarCurso"; // Nombre de la plantilla Thymeleaf
        } else {
            return "redirect:/admin/cursos/listar"; // Redirige si no se encuentra el curso
        }
    }

    @PostMapping("/guardar")
    public String saveCurso(@ModelAttribute Curso curso) {
        cursoService.save(curso);
        return "redirect:/cursos/listar"; // Redirige a la lista después de guardar
    }

    @GetMapping("/eliminar/{id}")
    public String deleteCurso(@PathVariable Integer id) {
        cursoService.deleteCurso(id);
        return "redirect:/cursos/listar"; // Redirige a la lista después de eliminar
    }
}
