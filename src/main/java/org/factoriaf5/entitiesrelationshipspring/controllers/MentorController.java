package org.factoriaf5.entitiesrelationshipspring.controllers;


import org.factoriaf5.entitiesrelationshipspring.entities.Mentor;
import org.factoriaf5.entitiesrelationshipspring.entities.Patient;
import org.factoriaf5.entitiesrelationshipspring.repositories.MentorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mentors")
public class MentorController {
    private final MentorRepository mentorRepository;
    
    public MentorController(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }
    
    // POST Crear mentor
   @PostMapping("/createMentor")
    public Mentor createMentor(@RequestBody Mentor mentor){
      return mentorRepository.save(mentor);
   }
   
   // GET Ver todos los mentors
    @GetMapping
    public List<Mentor> getAllMentors(){
        return this.mentorRepository.findAll();
    }
    
    // GET Ver Mentor por id
    @GetMapping("/{id}")
    public ResponseEntity<Mentor> optionalMentor(@PathVariable Long id){
        Optional<Mentor> optionalMentor = mentorRepository.findById(id);
        
        if(optionalMentor.isPresent()){
         return ResponseEntity.ok().body(optionalMentor.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    
    // Delete Borrar Mentor por id
    @DeleteMapping("/{id}")
    public void deleteMentorById(@PathVariable Long id){
        this.mentorRepository.deleteById(id);
    }
    
    
    // Crear Mentor con Pacientes
    @PostMapping
    public Mentor createMentorWithPatients(@RequestBody Mentor mentor) {
        // Asocia cada paciente al mentor
        if (mentor.getPatients() != null) {
            for (Patient patient : mentor.getPatients()) {
                patient.setMentor(mentor);
            }
        }
        return mentorRepository.save(mentor);
    }
    
    // Este endpoint devuelve un mentor junto con todos sus pacientes.
    @GetMapping("/{id}/patients")
    public ResponseEntity<Mentor> getMentorWithPatients(@PathVariable Long id) {
        Optional<Mentor> optionalMentor = mentorRepository.findById(id);
        
        if (optionalMentor.isPresent()) {
            Mentor mentor = optionalMentor.get();
            return ResponseEntity.ok(mentor); // Devuelve el mentor con sus pacientes
        }
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Si no existe, devuelve 404
    }
    
    
    
    
}
