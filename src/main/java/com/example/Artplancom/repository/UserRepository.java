package com.example.Artplancom.repository;

import com.example.Artplancom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String> {

   User findByName(String name);

}
