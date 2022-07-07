package com.example.Artplancom.repository;

import com.example.Artplancom.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;


import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Override
    Optional<Animal> findById(Long id);
    long deleteByNickName(String nickName);
    List<Animal> findByUser_Id(Long id);

}
