package com.by.blue.berries.repos;

import com.by.blue.berries.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Modifying
    @Query("UPDATE Product p SET p.price=?1, p.productName=?2 WHERE p.id = ?3")
    void updateProductById(Double price, String productName, Long id);
}
