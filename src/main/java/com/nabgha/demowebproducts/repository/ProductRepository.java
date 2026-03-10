package com.nabgha.demowebproducts.repository;


import com.nabgha.demowebproducts.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
