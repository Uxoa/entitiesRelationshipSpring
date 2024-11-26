package org.factoriaf5.entitiesrelationshipspring.controllers;

import org.factoriaf5.entitiesrelationshipspring.entities.Mentor;
import org.factoriaf5.entitiesrelationshipspring.entities.Patient;
import org.factoriaf5.entitiesrelationshipspring.repositories.MentorRepository;
import org.factoriaf5.entitiesrelationshipspring.repositories.PatientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {
    
    // Inyecto PatientRepository como parámetro
    private final PatientRepository patientRepository;
    private final MentorRepository mentorRepository;
    
    public PatientController(PatientRepository patientRepository, MentorRepository mentorRepository) {
        this.patientRepository = patientRepository;
        this.mentorRepository = mentorRepository;
    }
    
    
    // POST ->  Crear un paciente
    @PostMapping
    public Patient createPatient(@RequestBody Patient patient){
        return this.patientRepository.save(patient);
    }
    
    // GET -> Ver todos los pacientes
    @GetMapping
    public List<Patient> getAllPatients(){
        return this.patientRepository.findAll();
    }
    
    // GET -> Ver paciente por id
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id){
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        
        if(optionalPatient.isPresent()){
            return new ResponseEntity<>(optionalPatient.get(), HttpStatus.FOUND);
        }
        return new  ResponseEntity(HttpStatus.NOT_FOUND);
    }
    
    // DELETE -> Borrar paciente por id
    @DeleteMapping("/{id}")
    public void deletePatientById(@PathVariable Long id){
        patientRepository.deleteById(id);
    }
    
    //  lógica para asignar un mentor al crear un paciente
    @PostMapping("/{mentorId}")
    public ResponseEntity<Patient> createPatientForMentor(@PathVariable Long mentorId, @RequestBody Patient patient) {
        Optional<Mentor> optionalMentor = mentorRepository.findById(mentorId);
        if (optionalMentor.isPresent()) {
            Mentor mentor = optionalMentor.get();
            mentor.addPatient(patient);
            mentorRepository.save(mentor); // Guardar mentor guarda los pacientes en cascada
            return new ResponseEntity<>(patient, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}
