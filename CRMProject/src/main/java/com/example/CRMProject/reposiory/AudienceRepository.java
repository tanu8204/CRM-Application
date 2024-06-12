package com.example.CRMProject.repository;

import com.example.CRMProject.dto.AudienceCriteria;
import com.example.CRMProject.entity.Audience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudienceRepository extends JpaRepository<Audience, Long> {
    Audience save(Audience audience); // Override save method to return Audience object

    // Custom method to create audience based on criteria
    default Audience createAudience(AudienceCriteria criteria) {
        Audience audience = new Audience();
        audience.setName(criteria.getName());
        audience.setCriteria(criteria.toString()); // Store criteria as string
        return save(audience);
    }
}
