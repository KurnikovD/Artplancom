package com.example.Artplancom.repository;

import com.example.Artplancom.entity.AnimalType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalTypeRepository extends JpaRepository<AnimalType, Long> {

    @Override
    List<AnimalType> findAll();
}
