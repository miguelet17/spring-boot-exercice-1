package com.miguel.persistence.entity;


import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.Table;
import lombok.*;
import jakarta.persistence.*; // Cambiado a jakarta.persistence


import java.util.*;

@Entity(name = "T_RATES")
@Table()
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true) // Para ignorar propiedades desconocidas en JSON
public class Rates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "brand_id")
    @ManyToOne
    private Brand brand;
    @JoinColumn(name = "product_id")
    @ManyToOne
    private Product product;
    @JoinColumn(name = "currency_code")
    @ManyToOne
    private Currency currency;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;
    private Integer price;
}
