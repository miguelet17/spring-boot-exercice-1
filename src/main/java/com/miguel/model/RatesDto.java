package com.miguel.model;


import com.fasterxml.jackson.annotation.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.*;


@Data
public class RatesDto {
    private Long id;
    private String brand;
    private String product;
    private String currency;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date startDate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date endDate;
    private String price;
}
