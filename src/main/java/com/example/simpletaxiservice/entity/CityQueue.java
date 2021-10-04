package com.example.simpletaxiservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "city_queue")
public class CityQueue {
    @Id
    @Column(name = "city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long city_id;
    @Column(name = "name")
    private String name;
    @Column(name = "queue")
    private String queue;

    public CityQueue(String name, String queue) {
        this.name = name;
        this.queue = queue;
    }
}
