package com.certus.edu.pe.controller;


import com.certus.edu.pe.modelo.CustomTimeEditor;
import com.certus.edu.pe.modelo.horarios;
import com.certus.edu.pe.servicios.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/horarios")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    // Muestra la lista de horarios
    @GetMapping("/listar")
    public String findAll(Model model) {
        List<horarios> horarios = horarioService.findAll();
        model.addAttribute("horarios", horarios);
        return "Horario/listadoHorario";
    }

    // Muestra un horario por ID
    @GetMapping("/{id}")
    public String findById(@PathVariable Integer id, Model model) {
        Optional<horarios> horario = horarioService.findById(id);
        if (horario.isPresent()) {
            model.addAttribute("horario", horario.get());
            return "horarios/detail";
        } else {
            return "redirect:/horarios/"; // Redirige si no se encuentra el horario
        }
    }

    // Muestra el formulario para crear un nuevo horario
    @GetMapping("/nuevo")
    public String newHorario(Model model) {
        model.addAttribute("horario", new horarios());
        return "Horario/formularioHorario";
    }

    // Guarda un nuevo horario
    @PostMapping("/guardar")
    public String save(@ModelAttribute horarios horario) {
        horarioService.save(horario);
        return  "redirect:/horarios/listar";
    }

    // Elimina un horario por ID
    @PostMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id) {
        horarioService.deleteById(id);
        return "redirect:/horarios/listar";
    }
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Time.class, new CustomTimeEditor(new SimpleDateFormat("HH:mm"), true));
    }
}
