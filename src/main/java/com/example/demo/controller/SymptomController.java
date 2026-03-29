package com.example.demo.controller;

import com.example.demo.model.Symptom;
import com.example.demo.repository.SymptomRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SymptomController {

    private final SymptomRepository symptomRepository;

    public SymptomController(SymptomRepository symptomRepository){
        this.symptomRepository = symptomRepository;
    }

    @GetMapping("/symptoms/{category}")
    public List<Symptom> getSymptoms(@PathVariable String category){
        return symptomRepository.findByCategory(category);
    }
}