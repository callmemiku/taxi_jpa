package com.example.simpletaxiservice.controller;

import com.example.simpletaxiservice.entity.Car;
import com.example.simpletaxiservice.entity.CityQueue;
import com.example.simpletaxiservice.entity.TaxiDriver;
import com.example.simpletaxiservice.service.car.CarService;
import com.example.simpletaxiservice.service.city.CityQueueService;
import com.example.simpletaxiservice.service.driver.TaxiDriverServiceCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    @Autowired
    private CarService carService;
    @Autowired
    private CityQueueService cityQueueService;
    @Autowired
    private TaxiDriverServiceCustom taxiDriverService;

    //CAR METHODS
    @GetMapping(path = "/find/car/{id}")
    public ResponseEntity<Car> getCar(@PathVariable Long id){
        return carService.findById(id);
    }
    @GetMapping(path = "/find/car/{model}")
    public ResponseEntity<List<Car>> getCar(@PathVariable String model){
        return carService.findByModel(model);
    }
    @PostMapping(path = "/add/car")
    public ResponseEntity addCar(@RequestBody Car car){
        return carService.addCar(car);
    }
    @GetMapping(path = "/add/car/{model}")
    public ResponseEntity addCar(@PathVariable String model){
        return carService.addCar(model);
    }
    @PostMapping(path = "/delete/car")
    public ResponseEntity deleteCar(@RequestBody Car car){
        return carService.deleteCar(car);
    }
    @GetMapping(path = "/delete/car/{id}")
    public ResponseEntity deleteCar(@PathVariable Long id){
        return carService.deleteCar(id);
    }
    @GetMapping(path = "/delete/cars/{model}")
    public ResponseEntity deleteCars(@PathVariable String model){
        return carService.deleteCarsByModel(model);
    }


    //QUEUE METHODS
    @GetMapping(path = "/find/queue/{id}")
    public ResponseEntity<CityQueue> getQ(@PathVariable Long id){
        return cityQueueService.find(id);
    }
    @GetMapping(path = "/find/queue/city/{city}")
    public ResponseEntity<CityQueue> getQ(@PathVariable String city){
        return cityQueueService.find(city);
    }
    @PostMapping(path = "/add/queue")
    public ResponseEntity addQ(@RequestBody CityQueue cityQueue){
        return cityQueueService.addCityQueue(cityQueue);
    }
    @GetMapping(path = "/add/queue")
    public ResponseEntity addQ(@RequestParam(value = "name") String name, @RequestParam(value = "queue") String queue){
        return cityQueueService.addCityQueue(name, queue);
    }
    @PostMapping(path = "/delete/queue")
    public ResponseEntity deleteQ(@RequestBody CityQueue cityQueue){
        return cityQueueService.deleteQueue(cityQueue);
    }
    @GetMapping(path = "/delete/queue")
    public ResponseEntity deleteQ(@RequestParam(value = "name") String city){
        return cityQueueService.deleteQueue(city);
    }

    //TAXIDRIVER METHODS
    @GetMapping(path = "/find/driver/{id}")
    public ResponseEntity<TaxiDriver> getTaxiDriver(@PathVariable Long id){
        return taxiDriverService.findById(id);
    }
    @GetMapping(path = "/find/driver")
    public ResponseEntity<List<TaxiDriver>> getTaxiDriver(@RequestParam Map<String, String> params){
        return taxiDriverService.searchDynamically(params);
    }
    @PostMapping(path = "/add/driver")
    public void addTaxiDrive(@RequestBody TaxiDriver taxiDriver){
        taxiDriverService.add(taxiDriver);
    }
}
