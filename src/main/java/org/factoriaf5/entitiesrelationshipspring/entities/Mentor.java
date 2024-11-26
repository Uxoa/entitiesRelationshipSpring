package org.factoriaf5.entitiesrelationshipspring.entities;


import jakarta.persistence.*;

import java.io.FilenameFilter;

@Entity
@Table(name = "Mentors")
public class Mentor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMentor")
    private Long id;
    
    @Column(name = "nameMentor")
    private String nameMentor;
    
    public Mentor(Long id, String nameMentor) {
        this.id = id;
        this.nameMentor = nameMentor;
    }
    
    public Mentor() {
    
    }
    
    
    public Long getId() {
        return id;
    }
    
    public String getNameMentor() {
        return nameMentor;
    }
}
