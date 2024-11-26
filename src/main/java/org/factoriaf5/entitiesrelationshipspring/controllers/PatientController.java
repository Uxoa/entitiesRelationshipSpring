package org.factoriaf5.entitiesrelationshipspring.controllers;

import org.factoriaf5.entitiesrelationshipspring.entities.Patient;
import org.factoriaf5.entitiesrelationshipspring.repositories.PatientRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
    
}
