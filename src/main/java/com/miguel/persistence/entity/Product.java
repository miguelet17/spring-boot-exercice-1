package com.miguel.persistence.entity;


import lombok.*;

import jakarta.persistence.*; // Cambiado a jakarta.persistence

@Entity()
@Table()
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
}
