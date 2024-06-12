package com.example.CRMProject.controller;

import com.example.CRMProject.Service.AudienceService;
import com.example.CRMProject.dto.AudienceCriteria;
import com.example.CRMProject.entity.Audience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/audiences")
public class AudienceController {

    @Autowired
    private AudienceService audienceService;

    @PostMapping("/create")
    public ResponseEntity<Audience> createAudience(@RequestBody AudienceCriteria criteria) {
        Audience audience = audienceService.createAudience(criteria);
        return new ResponseEntity<>(audience, HttpStatus.CREATED);
    }
}

