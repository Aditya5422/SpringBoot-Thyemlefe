package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {

	
	/*
	 * @Query(value = "select * from product p where p.name like %:keyword%",
	 * nativeQuery = true) List<Product> findByKayword(@Param("keyword") String
	 * keyword);
	 */
	
	 @Query("SELECT p FROM Product p WHERE CONCAT(p.name) LIKE %?1%")
	 public List<Product> findAll(String keyword);
	 
	
	 
	 
}