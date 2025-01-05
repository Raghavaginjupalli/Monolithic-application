package com.project.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
public class Product {
    
	
    // Product details
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private String name;
	private String description;
	private String brand;
	private int price;
	private String category;
	private String releaseDate;
	private boolean productAvailable;
	private int stockQuantity;
	private String imageName;
	private String imageType;
	@Lob
	private byte[] imageData;

}
