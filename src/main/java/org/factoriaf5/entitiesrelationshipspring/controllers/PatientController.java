package org.factoriaf5.entitiesrelationshipspring.controllers;

import org.factoriaf5.entitiesrelationshipspring.entities.Patient;
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
    
    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
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
    
}
