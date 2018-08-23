package com.example.parkingboytddpractice.repositories;

import com.example.parkingboytddpractice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
