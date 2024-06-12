package com.example.CRMProject.Service;

import com.example.CRMProject.entity.Audience;
import com.example.CRMProject.entity.CommunicationLog;
import com.example.CRMProject.reposiory.CommunicationLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CampaignService {

    @Autowired
    private CommunicationLogRepository communicationLogRepository;

    public void sendCampaign(Audience audience) {
        // Implement logic to send campaigns based on audience criteria
        // For now, let's assume a dummy implementation
        String message = "Hi there!";
        String recipient = "dummy@example.com";
        boolean deliveryStatus = true; // Assuming the message is sent successfully

        // Save communication details in communications_log table
        CommunicationLog communicationLog = new CommunicationLog();
        communicationLog.setAudience(audience);
        communicationLog.setRecipient(recipient);
        communicationLog.setMessage(message);
        communicationLog.setSentDateTime(LocalDateTime.now());
        communicationLog.setDeliveryStatus(deliveryStatus);

        // Use the save method provided by JpaRepository to save the entity
        communicationLogRepository.save(communicationLog);
    }
}
