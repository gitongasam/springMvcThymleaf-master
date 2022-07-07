package com.devSam.springMvcThymleaf.Repository;

import com.devSam.springMvcThymleaf.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

 }
