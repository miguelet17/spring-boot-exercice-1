package com.miguel.core.mapper;


import com.miguel.model.RatesDto;
import com.miguel.model.out.RatesOutDto;
import com.miguel.persistence.entity.Rates;
import org.mapstruct.*;
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RateMapper {
  @Mapping(target = "brand", source = "brand.id")
  @Mapping(target = "product", source = "product.id")
  @Mapping(target = "currency", source = "currency")
  @Mapping(
      target = "price",
      expression =
          "java( String.format(\"%.\"+rates.getCurrency().getDecimals()+\"f\", rates.getPrice().doubleValue()))")
  RatesOutDto rateDtoFromRate(Rates rates);

  @Mapping(target = "brand.id", source = "brand")
  @Mapping(target = "product.id", source = "product")
  @Mapping(target = "currency.code", source = "currency")
    Rates rateFromRateDto(RatesDto retes);


}
