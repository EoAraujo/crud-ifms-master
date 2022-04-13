package br.edu.ifms.crudspring.services;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.crudspring.model.Professor;
import br.edu.ifms.crudspring.repositories.ProfessorRepository;


@Service
public class ProfessorService {
    
    @Autowired
    ProfessorRepository repository;
 
    public List<Professor> getProfessor(){  
        return  repository.findAll();
    }  
        
     public void save(Professor professor){
         this.repository.save(professor);
     }   
  
     public void delete(UUID id){
         repository.deleteById(id);    
     }

     public Professor findById(UUID id){  
         return repository.findById(id).get(); 
     }

     public void updateProfessor(Professor professor){ 
          repository.save(professor);     
     }
}
