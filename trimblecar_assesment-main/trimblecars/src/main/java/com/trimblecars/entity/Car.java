package com.trimblecars.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars")
public class Car {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private String brand;
    private String status; // IDEAL, ON_LEASE, ON_SERVICE

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;
}
