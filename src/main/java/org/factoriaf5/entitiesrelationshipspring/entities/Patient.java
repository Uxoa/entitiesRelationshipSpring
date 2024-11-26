package org.factoriaf5.entitiesrelationshipspring.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Patients")
public class Patient {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPatient")
    private Long id;
    
    @Column(name = "namePatient")
    private String namePatient;
    
    @Column(name = "speciePatient")
    private String speciePatient;
    
    @Column(name = "racePatient")
    private String racePatient;
    
    public Patient(Long id, String namePatient, String speciePatient, String racePatient) {
        this.id = id;
        this.namePatient = namePatient;
        this.speciePatient = speciePatient;
        this.racePatient = racePatient;
    }
    
    public Patient() {
    
    }
    
    
    public Long getId() {
        return id;
    }
    
    public String getNamePatient() {
        return namePatient;
    }
    
    public String getSpeciePatient() {
        return speciePatient;
    }
    
    public String getRacePatient() {
        return racePatient;
    }
}
