package com.example.java21.repository;

import com.example.java21.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAllByProductNMContaining(String searchValue);
}
