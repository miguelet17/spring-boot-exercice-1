package com.miguel.persistence.repository;

import com.miguel.persistence.entity.*;
import com.miguel.persistence.entity.Currency;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency,String> {
}
