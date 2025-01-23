package com.miguel.model.out;


import com.fasterxml.jackson.annotation.*;
import com.miguel.model.CurrencyDto;
import java.util.*;
import lombok.*;

@Data
public class RatesOutDto {
    private Long id;
    private String brand;
    private String product;
    private CurrencyDto currency;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date startDate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date endDate;
    private String price;
}
