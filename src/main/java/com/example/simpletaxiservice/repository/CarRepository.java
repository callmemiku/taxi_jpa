package com.example.simpletaxiservice.repository;

import com.example.simpletaxiservice.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByModel(String model);
    void deleteAllByModel(String model);
}
