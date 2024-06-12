package com.example.CRMProject.Service;
import jakarta.persistence.*;
import com.example.CRMProject.dto.AudienceCriteria;
import com.example.CRMProject.entity.Audience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AudienceService {

    @Autowired
    private com.example.CRMProject.repository.AudienceRepository audienceRepository;

    public Audience createAudience(AudienceCriteria criteria) {
        // Logic to validate and store the audience criteria
        Audience audience = new Audience();
        audience.setName(criteria.getName());
        audience.setCriteria(String.valueOf(criteria));
        // Save audience to database
        return audienceRepository.save(audience);
    }
}

