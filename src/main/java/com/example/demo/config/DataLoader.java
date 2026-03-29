package com.example.demo.config;

import com.example.demo.model.*;
import com.example.demo.repository.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataLoader {

@Bean
CommandLineRunner loadData(CategoryRepository categoryRepo,
                           DiseaseRepository diseaseRepo,
                           SymptomRepository symptomRepo) {

return args -> {


// ================= CATEGORIES =================

Category skin = new Category();
skin.setName("Skin Issues");
categoryRepo.save(skin);

Category fever = new Category();
fever.setName("Fever & Infection");
categoryRepo.save(fever);

Category respiratory = new Category();
respiratory.setName("Respiratory Problems");
categoryRepo.save(respiratory);

Category digestive = new Category();
digestive.setName("Digestive Issues");
categoryRepo.save(digestive);

Category pain = new Category();
pain.setName("Body Pain");
categoryRepo.save(pain);

Category neuro = new Category();
neuro.setName("Neurological");
categoryRepo.save(neuro);


// ================= SYMPTOMS =================

Symptom itching = saveSymptom("Itching",2,symptomRepo);
Symptom rash = saveSymptom("Rash",3,symptomRepo);
Symptom redness = saveSymptom("Redness",2,symptomRepo);
Symptom swelling = saveSymptom("Swelling",2,symptomRepo);
Symptom blisters = saveSymptom("Blisters",3,symptomRepo);
Symptom drySkin = saveSymptom("Dry skin",2,symptomRepo);

Symptom feverHigh = saveSymptom("High Fever",5,symptomRepo);
Symptom feverMild = saveSymptom("Mild Fever",3,symptomRepo);
Symptom chills = saveSymptom("Chills",4,symptomRepo);
Symptom fatigue = saveSymptom("Fatigue",2,symptomRepo);
Symptom sweating = saveSymptom("Sweating",2,symptomRepo);

Symptom cough = saveSymptom("Cough",3,symptomRepo);
Symptom soreThroat = saveSymptom("Sore throat",3,symptomRepo);
Symptom breathShort = saveSymptom("Shortness of breath",4,symptomRepo);
Symptom chestPain = saveSymptom("Chest pain",4,symptomRepo);
Symptom runnyNose = saveSymptom("Runny nose",2,symptomRepo);
Symptom sneezing = saveSymptom("Sneezing",2,symptomRepo);
Symptom wheezing = saveSymptom("Wheezing",4,symptomRepo);

Symptom nausea = saveSymptom("Nausea",3,symptomRepo);
Symptom vomiting = saveSymptom("Vomiting",3,symptomRepo);
Symptom diarrhea = saveSymptom("Diarrhea",3,symptomRepo);
Symptom abdominalPain = saveSymptom("Abdominal pain",3,symptomRepo);
Symptom heartburn = saveSymptom("Heartburn",3,symptomRepo);
Symptom bloating = saveSymptom("Bloating",2,symptomRepo);

Symptom jointPain = saveSymptom("Joint pain",4,symptomRepo);
Symptom musclePain = saveSymptom("Muscle pain",3,symptomRepo);
Symptom backPain = saveSymptom("Back pain",3,symptomRepo);
Symptom stiffness = saveSymptom("Joint stiffness",3,symptomRepo);

Symptom headache = saveSymptom("Headache",3,symptomRepo);
Symptom dizziness = saveSymptom("Dizziness",3,symptomRepo);
Symptom lightSensitivity = saveSymptom("Sensitivity to light",3,symptomRepo);
Symptom blurredVision = saveSymptom("Blurred vision",3,symptomRepo);


// ================= SKIN DISEASES =================

saveDisease("Scabies","Parasitic skin infection","MODERATE",
skin,List.of(itching,rash,blisters),diseaseRepo);

saveDisease("Eczema","Inflammatory skin condition","LOW",
skin,List.of(itching,redness,drySkin),diseaseRepo);

saveDisease("Dermatitis","Allergic skin reaction","LOW",
skin,List.of(redness,swelling),diseaseRepo);

saveDisease("Fungal Infection","Fungal skin infection","LOW",
skin,List.of(itching,rash),diseaseRepo);

saveDisease("Psoriasis","Autoimmune skin disease","MODERATE",
skin,List.of(redness,drySkin),diseaseRepo);


// ================= FEVER DISEASES =================

saveDisease("Viral Fever","Common viral infection","LOW",
fever,List.of(feverMild,fatigue),diseaseRepo);

saveDisease("Dengue","Mosquito virus infection","HIGH",
fever,List.of(feverHigh,jointPain,headache),diseaseRepo);

saveDisease("Malaria","Mosquito parasite infection","HIGH",
fever,List.of(feverHigh,chills,sweating),diseaseRepo);

saveDisease("Typhoid","Bacterial fever infection","HIGH",
fever,List.of(feverHigh,headache,fatigue),diseaseRepo);

saveDisease("Influenza","Flu virus infection","MODERATE",
fever,List.of(feverMild,cough,fatigue),diseaseRepo);


// ================= RESPIRATORY =================

saveDisease("Common Cold","Upper respiratory infection","LOW",
respiratory,List.of(runnyNose,sneezing,cough),diseaseRepo);

saveDisease("Bronchitis","Inflamed bronchial tubes","MODERATE",
respiratory,List.of(cough,chestPain),diseaseRepo);

saveDisease("Pneumonia","Lung infection","HIGH",
respiratory,List.of(feverHigh,cough,breathShort),diseaseRepo);

saveDisease("Asthma","Airway inflammation","MODERATE",
respiratory,List.of(breathShort,wheezing,cough),diseaseRepo);

saveDisease("Sinusitis","Sinus infection","LOW",
respiratory,List.of(headache,runnyNose),diseaseRepo);


// ================= DIGESTIVE =================

saveDisease("Food Poisoning","Contaminated food illness","MODERATE",
digestive,List.of(vomiting,diarrhea),diseaseRepo);

saveDisease("Gastritis","Stomach inflammation","LOW",
digestive,List.of(abdominalPain,heartburn),diseaseRepo);

saveDisease("Acid Reflux","Acid reflux disease","LOW",
digestive,List.of(heartburn,bloating),diseaseRepo);

saveDisease("Gastroenteritis","Stomach infection","MODERATE",
digestive,List.of(vomiting,diarrhea),diseaseRepo);


// ================= PAIN =================

saveDisease("Muscle Strain","Overstretched muscle","LOW",
pain,List.of(musclePain),diseaseRepo);

saveDisease("Arthritis","Joint inflammation","MODERATE",
pain,List.of(jointPain,stiffness),diseaseRepo);

saveDisease("Sciatica","Nerve compression","MODERATE",
pain,List.of(backPain),diseaseRepo);


// ================= NEURO =================

saveDisease("Migraine","Severe headache disorder","MODERATE",
neuro,List.of(headache,lightSensitivity),diseaseRepo);

saveDisease("Vertigo","Balance disorder","MODERATE",
neuro,List.of(dizziness),diseaseRepo);

saveDisease("Tension Headache","Stress headache","LOW",
neuro,List.of(headache),diseaseRepo);

};

}


// ================= HELPER METHODS =================

private Symptom saveSymptom(String name,int weight,SymptomRepository repo){

Symptom s=new Symptom();
s.setName(name);
s.setWeight(weight);

return repo.save(s);

}

private void saveDisease(String name,String desc,String severity,
Category category,List<Symptom> symptoms,
DiseaseRepository diseaseRepo){

Disease d=new Disease();

d.setName(name);
d.setDescription(desc);
d.setSeverityLevel(severity);
d.setCategory(category);
d.setSymptoms(symptoms);

diseaseRepo.save(d);

}

}