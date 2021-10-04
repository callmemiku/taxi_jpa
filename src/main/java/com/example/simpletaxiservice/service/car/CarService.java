package com.example.simpletaxiservice.service.car;

import com.example.simpletaxiservice.entity.Car;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CarService {
    ResponseEntity<Car> findById(Long id);
    ResponseEntity<List<Car>> findByModel(String model);
    ResponseEntity addCar(Car car);
    ResponseEntity addCar(String model);
    ResponseEntity deleteCar(Long id);
    ResponseEntity deleteCarsByModel(String model);
    ResponseEntity deleteCar(Car car);
}
