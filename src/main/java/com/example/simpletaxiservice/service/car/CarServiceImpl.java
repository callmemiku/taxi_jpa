package com.example.simpletaxiservice.service.car;

import com.example.simpletaxiservice.entity.Car;
import com.example.simpletaxiservice.repository.CarRepository;
import liquibase.pro.packaged.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public ResponseEntity<Car> findById(Long id) {
        Optional<Car> car = carRepository.findById(id);
        return car.map(value ->
                new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() ->
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<List<Car>> findByModel(String model) {
        return new ResponseEntity<>(carRepository.findByModel(model), HttpStatus.OK);
    }

    @Override
    public ResponseEntity addCar(String model) {
        carRepository.saveAndFlush(new Car(model));
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    public ResponseEntity addCar(Car car) {
        carRepository.saveAndFlush(car);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Transactional
    @Override
    public ResponseEntity deleteCar(Long id) {
        carRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    @Transactional
    @Override
    public ResponseEntity deleteCar(Car car) {
        carRepository.delete(car);
        return new ResponseEntity(HttpStatus.OK);
    }
    @Transactional
    @Override
    public ResponseEntity deleteCarsByModel(String model) {
        carRepository.deleteAllByModel(model);
        return new ResponseEntity(HttpStatus.OK);
    }
}
