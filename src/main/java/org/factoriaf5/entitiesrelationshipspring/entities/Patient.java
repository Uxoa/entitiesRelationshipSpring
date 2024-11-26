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
    
    // RELACIÓN MANY TO ONE
    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private Mentor mentor;
    
    public Patient(Long id, String namePatient, String speciePatient, String racePatient, Mentor mentor) {
        this.id = id;
        this.namePatient = namePatient;
        this.speciePatient = speciePatient;
        this.racePatient = racePatient;
        this.mentor = mentor;
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
    
    
    public Mentor getMentor() {
        return mentor;
    }
    
    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }
}
