package com.miguel.persistence.repository;

import com.miguel.persistence.entity.*;
import com.miguel.persistence.entity.Rates;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface RatesRepository extends JpaRepository<Rates,Long>,JpaSpecificationExecutor<Rates> {
}
