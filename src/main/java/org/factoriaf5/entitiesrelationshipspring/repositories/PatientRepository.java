package org.factoriaf5.entitiesrelationshipspring.repositories;

import org.factoriaf5.entitiesrelationshipspring.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
