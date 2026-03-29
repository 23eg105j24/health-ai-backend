package com.example.demo.repository;

import com.example.demo.model.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiseaseRepository extends JpaRepository<Disease, Long> {

    List<Disease> findByCategoryName(String name);

}