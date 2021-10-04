package com.example.simpletaxiservice.repository;

import com.example.simpletaxiservice.entity.CityQueue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityQueueRepository extends JpaRepository<CityQueue, Long> {
    Optional<CityQueue> findByName(String city);
    void deleteByName(String cityName);
}
