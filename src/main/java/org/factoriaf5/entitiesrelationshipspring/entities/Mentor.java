package org.factoriaf5.entitiesrelationshipspring.entities;


import jakarta.persistence.*;

import java.io.FilenameFilter;
import java.util.List;

@Entity
@Table(name = "Mentors")
public class Mentor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMentor")
    private Long id;
    
    @Column(name = "nameMentor")
    private String nameMentor;
    
    // RELACIÓN ONE TO MANY
    @OneToMany(mappedBy = "mentor", cascade = CascadeType.ALL)
    private List<Patient> patient;
    
    public Mentor(Long id, String nameMentor, List<Patient> patient) {
        this.id = id;
        this.nameMentor = nameMentor;
        this.patient = patient;
    }
    
    public Mentor() {
    
    }
    
    public Long getId() {
        return id;
    }
    
    public String getNameMentor() {
        return nameMentor;
    }
    
    public List<Patient> getPatients() {
        return patient;
    }
    
    public void setPatient(List<Patient> patient) {
        this.patient = patient;
    }
    
    public void addPatient(Patient patient) {
    
    }
}
