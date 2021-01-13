package com.products.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.products.apirest.models.Meters;

public interface MeterRepository extends JpaRepository<Meters, Long> {
	
	Meters findById(long id);

}
