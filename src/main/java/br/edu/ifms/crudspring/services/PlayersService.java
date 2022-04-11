package br.edu.ifms.crudspring.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.crudspring.model.Players;
import br.edu.ifms.crudspring.repositories.PlayersRepository;

@Service
public class PlayersService {
    
    @Autowired
    PlayersRepository repository;
 
    public List<Players> getPlayers(){  
        return  repository.findAll();
    }  
        
     public void save(Players student){
         this.repository.save(student);
     }   
  
     public void delete(UUID id){
         repository.deleteById(id);    
     }

     public Players findById(UUID id){  
         return repository.findById(id).get(); 
     }

     public void updateStudent(Players players){ 
          repository.save(players);     
     }
} 



