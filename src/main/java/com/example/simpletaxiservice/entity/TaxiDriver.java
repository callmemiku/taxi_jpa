package com.example.simpletaxiservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "taxi_drive_info")
public class TaxiDriver {
    @Id
    @Column(name = "driver_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long driver_id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName = null;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "level")
    private int level;
    @Column(name = "car_model")
    private String carModel;

    public TaxiDriver(String firstName, String lastName, int level, String carModel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.level = level;
        this.carModel = carModel;
    }

    public TaxiDriver(String firstName, String middleName, String lastName, int level, String carModel) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.level = level;
        this.carModel = carModel;
    }
}
