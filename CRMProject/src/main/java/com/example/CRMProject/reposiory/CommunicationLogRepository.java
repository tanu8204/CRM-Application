package com.example.CRMProject.reposiory;

import com.example.CRMProject.entity.CommunicationLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunicationLogRepository extends JpaRepository<CommunicationLog, Long> {
}
