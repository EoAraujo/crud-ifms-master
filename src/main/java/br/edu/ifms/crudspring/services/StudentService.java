package br.edu.ifms.crudspring.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.crudspring.model.Student;
import br.edu.ifms.crudspring.repositories.StudentRepository;

@Service
public class StudentService { 
     
    @Autowired
    StudentRepository repository;
 
    public List<Student> getStudents(){  
        return  repository.findAll();
    }  
        
     public void save(Student student){
         this.repository.save(student);
     }   
  
     public void delete(UUID id){
         repository.deleteById(id);    
     }

     public Student findById(UUID id){  
         return repository.findById(id).get(); 
     }

     public void updateStudent(Student student){ 
          repository.save(student);     
     }
} 

