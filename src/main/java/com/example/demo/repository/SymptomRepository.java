package com.example.demo.repository;

import com.example.demo.model.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SymptomRepository extends JpaRepository<Symptom, Long> {

    @Query("""
    SELECT DISTINCT s
    FROM Disease d
    JOIN d.symptoms s
    WHERE d.category.name = :category
    """)
    List<Symptom> findByCategory(String category);

}