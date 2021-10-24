package com.by.blue.berries.repos;

import com.by.blue.berries.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
