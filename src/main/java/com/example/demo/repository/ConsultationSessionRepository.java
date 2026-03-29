package com.example.demo.repository;

import com.example.demo.model.ConsultationSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationSessionRepository
        extends JpaRepository<ConsultationSession, Long> {
}