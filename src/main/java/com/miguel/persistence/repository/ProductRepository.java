package com.miguel.persistence.repository;

import com.miguel.persistence.entity.*;
import com.miguel.persistence.entity.Product;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
