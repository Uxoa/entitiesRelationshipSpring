package org.factoriaf5.entitiesrelationshipspring.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
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
    @OneToMany(mappedBy = "mentor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Patient> patients = new ArrayList<>();
    
    public Mentor(Long id, String nameMentor, List<Patient> patients) {
        this.id = id;
        this.nameMentor = nameMentor;
        this.patients = patients;
    }
    
    public Mentor() {
    }
    
    public Long getId() {
        return id;
    }
    
    public String getNameMentor() {
        return nameMentor;
    }
    
    public void setNameMentor(String nameMentor) {
        this.nameMentor = nameMentor;
    }
    
    public List<Patient> getPatients() {
        return patients;
    }
    
    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
    
    // Método para añadir un paciente
    public void addPatient(Patient patient) {
        this.patients.add(patient);  // Añade el paciente a la lista
        patient.setMentor(this);    // Establece la relación bidireccional
    }
    
    // Método para eliminar un paciente
    public void removePatient(Patient patient) {
        this.patients.remove(patient); // Elimina el paciente de la lista
        patient.setMentor(null);       // Rompe la relación bidireccional
    }
}
