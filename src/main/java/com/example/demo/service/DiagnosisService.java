package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DiagnosisService {

    private final DiseaseRepository diseaseRepository;
    private final GroqAIService groqAIService;

    public DiagnosisService(DiseaseRepository diseaseRepository,
                            GroqAIService groqAIService) {
        this.diseaseRepository = diseaseRepository;
        this.groqAIService = groqAIService;
    }

    public Map<String,Object> analyze(Map<String,Object> request){

        List<String> selectedSymptoms =
        (List<String>) request.get("symptoms");

        List<Disease> diseases = diseaseRepository.findAll();

        Disease bestMatch = null;
        int bestScore = 0;

        for(Disease disease : diseases){

            int score = 0;

            for(Symptom symptom : disease.getSymptoms()){

                if(selectedSymptoms.contains(symptom.getName())){
                    score += symptom.getWeight();
                }

            }

            if(score > bestScore){
                bestScore = score;
                bestMatch = disease;
            }

        }

        Map<String,Object> result = new HashMap<>();

        if(bestMatch != null){

            result.put("condition",bestMatch.getName());
            result.put("severity",bestMatch.getSeverityLevel());
            result.put("description",bestMatch.getDescription());
            result.put("confidence",bestScore * 10);

         // AI explanation
            Map<String,String> aiResponse =
            		groqAIService.generateExplanation(
            		        bestMatch.getName(),
            		        selectedSymptoms.toString()
            		);

            		result.put("aiExplanation", aiResponse.get("explanation"));
            		result.put("aiAdvice", aiResponse.get("advice"));

            		result.put("medicines",
            		        suggestMedicine(bestMatch.getName(),
            		                bestMatch.getSeverityLevel()));

        }

        return result;

    }


    private List<String> suggestMedicine(String disease,String severity){

        List<String> meds = new ArrayList<>();

        if(severity.equals("LOW") || severity.equals("MODERATE")){

            switch(disease){

                case "Common Cold":
                case "Flu":
                    meds.add("Paracetamol");
                    meds.add("Cetirizine");
                    meds.add("Steam Inhalation");
                    break;

                case "Food Poisoning":
                    meds.add("ORS");
                    meds.add("Domperidone");
                    meds.add("Electrolyte fluids");
                    break;

                case "Gastritis":
                    meds.add("Antacid");
                    meds.add("Omeprazole");
                    break;

                case "Eczema":
                case "Dermatitis":
                    meds.add("Hydrocortisone Cream");
                    meds.add("Moisturizing lotion");
                    break;

                case "Muscle Strain":
                    meds.add("Ibuprofen");
                    meds.add("Hot/Cold compress");
                    break;

                default:
                    meds.add("Paracetamol");
                    meds.add("Rest and hydration");
            }

        }else{

            meds.add("Consult a doctor immediately");

        }

        return meds;
    }

}