package com.example.simpletaxiservice.service.city;

import com.example.simpletaxiservice.entity.CityQueue;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public interface CityQueueService {
    ResponseEntity<CityQueue> find(Long id);
    ResponseEntity<CityQueue> find(String name);
    ResponseEntity addCityQueue(CityQueue cityQueue);
    ResponseEntity addCityQueue(String city, String queue);
    ResponseEntity deleteQueue(CityQueue cityQueue);
    ResponseEntity deleteQueue(String cityName);
}
