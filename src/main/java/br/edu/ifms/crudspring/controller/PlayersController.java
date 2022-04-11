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

import br.edu.ifms.crudspring.model.Players;
import br.edu.ifms.crudspring.services.PlayersService;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/players") 
@Slf4j
public class PlayersController {
    

    @Autowired
    PlayersService service;

    @PostMapping("/")
    public String save(@ModelAttribute("student") Players players) {
        service.save(players);
        return "redirect:/student/";
    }

  
    @GetMapping("/")
    public String locAll(Model model) {
        List<Players> students = service.getPlayers();
        model.addAttribute("players", students);
        return "index";
    }


    @GetMapping("/cadastrar-players")
    public String newStudent(Model model) {
        model.addAttribute("player-cad", new Players());
        return "cadastrar";
    }
  
    @GetMapping("/remove/{id}")
    public String removerPlayer(@PathVariable("id") UUID id){
       
        log.info("id = " + id); 
        service.delete(id);
        return "redirect:/student/"; 
    }

    @GetMapping("/edit/{id}")
    public String editPlayer(@PathVariable("id") UUID id, Model model){
           
        log.info("id = editado", id);

        Players players = service.findById(id);
        model.addAttribute("student", players);
    
        return "editPlayers";
    }

    @PostMapping("/update/{id}")
    public String updatePlayer(@PathVariable("id") UUID id, @ModelAttribute Players players){
        service.save(players);

        return "redirect:/student/";
    }

}
