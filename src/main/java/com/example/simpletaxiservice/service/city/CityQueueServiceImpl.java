package com.example.simpletaxiservice.service.city;

import com.example.simpletaxiservice.entity.CityQueue;
import com.example.simpletaxiservice.repository.CityQueueRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Slf4j
@Service
public class CityQueueServiceImpl implements CityQueueService {

    @Autowired
    private CityQueueRepository cityQueueRepository;

    @Override
    public ResponseEntity<CityQueue> find(Long id) {
        Optional<CityQueue> cityQueue = cityQueueRepository.findById(id);
        return cityQueue.map(queue ->
                new ResponseEntity<>(queue, HttpStatus.OK)).orElseGet(() ->
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<CityQueue> find(String name) {
        Optional<CityQueue> cityQueue = cityQueueRepository.findByName(name);
        return cityQueue.map(queue ->
                new ResponseEntity<>(queue, HttpStatus.OK)).orElseGet(() ->
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity addCityQueue(CityQueue cityQueue) {
        cityQueueRepository.saveAndFlush(cityQueue);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    public ResponseEntity addCityQueue(String city, String name) {
        cityQueueRepository.saveAndFlush(new CityQueue(city, name));
        return new ResponseEntity(HttpStatus.OK);
    }
    @Transactional
    @Override
    public ResponseEntity deleteQueue(CityQueue cityQueue) {
        cityQueueRepository.delete(cityQueue);
        return new ResponseEntity(HttpStatus.OK);
    }
    @Transactional
    @Override
    public ResponseEntity deleteQueue(String cityName) {
        cityQueueRepository.deleteByName(cityName);
        return new ResponseEntity(HttpStatus.OK);
    }
}
