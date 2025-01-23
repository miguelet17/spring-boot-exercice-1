package com.miguel.persistence.repository;

import com.miguel.persistence.entity.Brand;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Long> {
}
