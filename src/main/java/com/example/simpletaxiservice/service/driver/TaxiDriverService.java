package com.example.simpletaxiservice.service.driver;

import com.example.simpletaxiservice.entity.TaxiDriver;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaxiDriverService {
    ResponseEntity<TaxiDriver> findById(Long id);
    ResponseEntity<List<TaxiDriver>> findByLevel(int level);
    ResponseEntity<List<TaxiDriver>> findByCar(String carModel);
    void add(TaxiDriver taxiDriver);
}
