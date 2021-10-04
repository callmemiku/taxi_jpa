package com.example.simpletaxiservice.repository;

import com.example.simpletaxiservice.entity.TaxiDriver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaxiDriverRepository extends JpaRepository<TaxiDriver, Long> {

    List<TaxiDriver> findAllByLevel(int level);

    List<TaxiDriver> findAllByCarModelLike(String carModel);
}
