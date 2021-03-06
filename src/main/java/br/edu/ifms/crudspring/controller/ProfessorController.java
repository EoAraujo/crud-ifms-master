package br.edu.ifms.crudspring.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifms.crudspring.model.Professor;
import br.edu.ifms.crudspring.services.ProfessorService;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/professor") // o controller vai ser responsavel por receber as requisiçoes
@Slf4j
public class ProfessorController {
    @Autowired
    ProfessorService professorService;

    @PostMapping("/")
    public String save(@ModelAttribute("professor") Professor professor) {
        professorService.save(professor);
        return "redirect:/professor/";
    }

    @GetMapping("/")
    public String locAll(Model model) {
        List<Professor> professores = professorService.getProfessor();
        model.addAttribute("professores", professores);
        return "index_prof";
    }

    @GetMapping("/cadastrar_prof")
    public String newProfessor(Model model) {
        model.addAttribute("professor", new Professor());
        return "cadastrar_prof";
    }

    @GetMapping("/remove_prof/{id}")
    public String removerProfessor(@PathVariable("id") UUID id) {

        log.info("id = " + id);
        professorService.delete(id);
        return "redirect:/professor/";
    }

    @GetMapping("/edit_prof/{id}")
    public String editProfessor(@PathVariable("id") UUID id, Model model) {

        log.info("id = editado", id);

        Professor professor = professorService.findById(id);
        model.addAttribute("professor", professor);

        return "editProfessor";
    }

    @PostMapping("/update_prof/{id}")
    public String updateProfessor(@PathVariable("id") UUID id, @ModelAttribute Professor professor) {
        professorService.save(professor);

        return "redirect:/professor/";
    }

}
