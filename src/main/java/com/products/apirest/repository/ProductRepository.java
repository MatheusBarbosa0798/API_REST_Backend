package com.products.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.products.apirest.models.Products;

public interface ProductRepository extends JpaRepository<Products, Long> {
	
	Products findById(long id);

}
