package com.example.demo.controller;

import com.example.demo.service.DiagnosisService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/diagnosis")
@CrossOrigin
public class DiagnosisController {

    private final DiagnosisService diagnosisService;

    public DiagnosisController(DiagnosisService diagnosisService){
        this.diagnosisService = diagnosisService;
    }

    @PostMapping("/analyze")
    public Map<String,Object> analyze(@RequestBody Map<String,List<String>> request){

        List<String> symptoms = request.get("symptoms");

        return diagnosisService.analyze((Map<String, Object>) symptoms);
    }
}