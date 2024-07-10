package com.certus.edu.pe.controller;

import com.certus.edu.pe.modelo.Estudiante;
import com.certus.edu.pe.modelo.Profesor;
import com.certus.edu.pe.servicios.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/profesor") // Actualizado para incluir /colegio
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @GetMapping("/listar")
    public String findAll(Model model) {
        List<Profesor> listaProfesores = profesorService.findAll();
        model.addAttribute("listaProfesor", listaProfesores);
        return "Profesor/listadoProfesores";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Profesor findById(@PathVariable Integer id) {
        return profesorService.findById(id).orElse(null);
    }
    
    
    @PostMapping("/guardar")
    public String guardarProfesor(@ModelAttribute("profesor") Profesor profesor) {
        profesorService.save(profesor);
        return "redirect:/profesor/listar";
    }

    
    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Profesor profesor = profesorService.findById(id)
            .orElseThrow(() -> new RuntimeException("Profesor not found with id " + id));
        model.addAttribute("profesor", profesor);
        return "/Profesor/actualizarProfesor"; // Asegúrate de tener este archivo HTML
    }

    // Maneja la actualización del profesor
    @PostMapping("/actualizar/{id}")
    public String actualizarProfesor(@PathVariable("id") Integer id,
                                     @ModelAttribute("profesor") Profesor profesor) {
        profesor.setIdProfesor(id); // Establece el ID del profesor
        profesorService.save(profesor);
        return "redirect:/profesor/listar";
    }

    @PostMapping("/eliminar/{id}")
    public String deleteProfesor(@PathVariable("id") Integer id) {
        profesorService.deleteById(id);
        return "redirect:/profesor/listar";
    }

    @GetMapping("/eliminar")
    public String showDeleteList(Model model) {
        List<Profesor> listaProfesores = profesorService.findAll();
        model.addAttribute("listaProfesor", listaProfesores);
        return "profesor/eliminarProfesor";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("profesor", new Profesor());
        return "profesor/crearProfesor";
    }

    

   
}
