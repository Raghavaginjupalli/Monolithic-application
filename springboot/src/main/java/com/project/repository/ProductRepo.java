package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.project.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
	
	@Query("Select p from Product p Where " + 
		    "LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword ,'%')) OR "+
		    "LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword ,'%')) OR "+
		    "LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword ,'%')) OR "+
		    "LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword ,'%'))")
	List<Product> searchProducts(String keyword);

}
