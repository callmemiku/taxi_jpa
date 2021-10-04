package com.example.simpletaxiservice.service.driver;

import com.example.simpletaxiservice.entity.TaxiDriver;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface TaxiDriverServiceCustom extends TaxiDriverService {
    ResponseEntity<List<TaxiDriver>> searchDynamically(Map<String, String> parameters);
}
