package org.factoriaf5.entitiesrelationshipspring.repositories;

import org.factoriaf5.entitiesrelationshipspring.entities.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {
}
