package com.example.demo.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class ConsultationSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<String> selectedSymptoms = new ArrayList<>();

    @ElementCollection
    private List<String> askedQuestions = new ArrayList<>();

    @ElementCollection
    private List<Integer> confidenceHistory = new ArrayList<>();

    public Long getId() { return id; }

    public List<String> getSelectedSymptoms() {
        return selectedSymptoms;
    }

    public List<String> getAskedQuestions() {
        return askedQuestions;
    }

    public List<Integer> getConfidenceHistory() {
        return confidenceHistory;
    }
}