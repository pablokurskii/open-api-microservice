package com.prueba.manomano.repository;

import com.prueba.manomano.repository.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {



}
