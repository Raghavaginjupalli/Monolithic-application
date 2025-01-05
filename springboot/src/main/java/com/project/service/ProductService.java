package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import com.project.model.Product;
import com.project.repository.ProductRepo;


@Service
public class ProductService {
	
    // Extends of JpaRepository
	@Autowired
	ProductRepo repo;


	// Get all Products
    public List<Product> getProducts(){
    	return repo.findAll();
			
    }
    
    // Get Product by product id.
    public Product getProductById(int id) {
    	return repo.findById(id).orElse(null);
    	
	}
    
    // Get Product by searching.
    public List<Product> searchProducts(String keyword) {
    	return repo.searchProducts(keyword);
    	
	}
    // 	Adding new Product
	public void addProduct(Product newProduct,MultipartFile imageFile ) throws IOException {
			newProduct.setImageName(imageFile.getOriginalFilename());
			newProduct.setImageType(imageFile.getContentType());
			newProduct.setImageData(imageFile.getBytes());
			repo.save(newProduct);
			
	}
	
	// Updating existing product by product id.
	public void setProductById(Product updateProduct, MultipartFile imageFile) throws IOException {
		updateProduct.setImageName(imageFile.getOriginalFilename());
		updateProduct.setImageType(imageFile.getContentType());
		updateProduct.setImageData(imageFile.getBytes());
		repo.save(updateProduct);
	
	}
	
	// Delete Product by product id
	public void deleteProductById(int id) {
		repo.deleteById(id);

	}
    	    
}
