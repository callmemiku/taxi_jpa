package com.example.simpletaxiservice.service.driver;

import com.example.simpletaxiservice.entity.TaxiDriver;
import com.example.simpletaxiservice.repository.TaxiDriverRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Slf4j
@Service
public class TaxiDriverServiceCustomImpl implements TaxiDriverServiceCustom {

    @Autowired
    private TaxiDriverRepository taxiDriverRepository;
    @Autowired
    private EntityManager entityManager;

    @Override
    public ResponseEntity<TaxiDriver> findById(Long id) {
        log.info("TaxiDriver id search invoked.");
        return new ResponseEntity<>(taxiDriverRepository.getById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TaxiDriver>> findByLevel(int level) {
        log.info("TaxiDriver level search invoked.");
        return new ResponseEntity<>(taxiDriverRepository.findAllByLevel(level), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TaxiDriver>> findByCar(String carModel) {
        log.info("TaxiDriver car model search invoked.");
        return new ResponseEntity<>(taxiDriverRepository.findAllByCarModelLike(carModel), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TaxiDriver>> searchDynamically(Map<String, String> parameters) {

        if (parameters.size() == 0)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TaxiDriver> criteriaQuery = criteriaBuilder.createQuery(TaxiDriver.class);
        Root<TaxiDriver> root = criteriaQuery.from(TaxiDriver.class);
        List<Predicate> predicates = new ArrayList<>();

        if (parameters.size() == 1 && parameters.containsKey("level"))
            return findByLevel(Integer.parseInt(parameters.get("level")));


        if (parameters.size() == 1 && parameters.containsKey("carModel"))
            return findByCar(parameters.get("carModel"));


        log.info("Full set of criteria.");

        if (parameters.containsKey("firstName"))
            predicates.add(criteriaBuilder.like(root.get("firstName"), "%" + parameters.get("firstName") + "%"));
        if (parameters.containsKey("middleName"))
            predicates.add(criteriaBuilder.like(root.get("middleName"), "%" + parameters.get("middleName") + "%"));
        if (parameters.containsKey("lastName"))
            predicates.add(criteriaBuilder.like(root.get("lastName"), "%" + parameters.get("lastName") + "%"));
        if (parameters.containsKey("level"))
            predicates.add(criteriaBuilder.equal(root.get("level"), Integer.parseInt(parameters.get("level"))));
        if (parameters.containsKey("carModel"))
            predicates.add(criteriaBuilder.like(root.get("carModel"), "%" + parameters.get("carModel") + "%"));

        return new ResponseEntity<>(entityManager.createQuery(criteriaQuery.where(predicates.toArray(new Predicate[0]))).getResultList(), HttpStatus.OK);
    }

    @Override
    public void add(TaxiDriver taxiDriver) {
        taxiDriverRepository.saveAndFlush(taxiDriver);
    }
}
