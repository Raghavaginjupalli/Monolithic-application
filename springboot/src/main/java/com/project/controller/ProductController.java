package com.project.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.model.Product;
import com.project.service.ProductService;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

	ProductService service;

	// Constructor injection for ProductService object
	public ProductController(ProductService service) {
		this.service = service;
	}
	
	// Return all Products.
	@GetMapping("/products")
	public ResponseEntity<List<Product>> listOfProducts(){
		
		List<Product> products = service.getProducts();
		
		if (products!= null) {
			return new ResponseEntity<>(products, HttpStatus.OK);
		}
		
		// Return an empty list with a 200 status to indicate no products found
	    return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
	}
	
	
	// Return one Product by product id.
	@GetMapping("/product/{id}")
	public ResponseEntity<?> getProdById(@PathVariable int id) {
		Product product = service.getProductById(id);
		
		if (product!= null) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Product not found with ID: " + id, HttpStatus.NOT_FOUND);
	}
	
	
	// Return Product image by product id.
	@GetMapping("/product/{id}/image")
	public ResponseEntity<?> getImageById(@PathVariable int id) {
	    
		try {
			// Retrieving the product & Image data.
	        Product product = service.getProductById(id);
	        byte[] imageFile = product.getImageData();
        	
	        // Return the Image of given id.
	        return ResponseEntity.ok()
	                .contentType(MediaType.valueOf(product.getImageType()))
	                .body(imageFile);
	        
	    } catch (Exception e) {
	    	return new ResponseEntity<>("Image not found for the specified product ID.", HttpStatus.NOT_FOUND);
	    
	    }
	}
	
	
	// Return the Product the by searching.
	@GetMapping("/products/search")
	public ResponseEntity<?> getBySearch(@RequestParam String keyword) {
	    
		try {
			
			List<Product> products = service.searchProducts(keyword);
			return new ResponseEntity<>(products, HttpStatus.OK);
			
	    } catch (Exception e) {
	    	return new ResponseEntity<>("Image not found for the specified product ID.", HttpStatus.NOT_FOUND);
	    
	    }
	}

	
	// Creating new Product.
	@PostMapping("/product")
	public ResponseEntity<String> addProduct(@RequestPart Product newProduct, @RequestPart MultipartFile imageFile) throws IOException {
		
		try {
			Product product = service.getProductById(newProduct.getId());
			// Check if the product already exists
			if (product != null) {
				return new ResponseEntity<>("Product with the same ID already exists.", HttpStatus.CONFLICT);
			}
			
			// Add the new product
			service.addProduct(newProduct, imageFile);
			return new ResponseEntity<>("Product added successfully.", HttpStatus.CREATED);

		}catch (Exception e) {
			// Log the error
	        return new ResponseEntity<>("An error occurred while adding the product.", HttpStatus.INTERNAL_SERVER_ERROR);
		
		}	
	}
	
	
	// Updating existing product by product id.
	@PutMapping("/product/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestPart Product updateProduct, @RequestPart MultipartFile imageFile) throws IOException {
	   
		try {
			// Retrieve the existing product by ID
	        Product existingProduct = service.getProductById(id);

	        if (existingProduct == null) {
	            return new ResponseEntity<>("No product found with the specified ID.", HttpStatus.NOT_FOUND);
	        }

	        // Ensure the provided product ID matches the path variable
	        if (id != updateProduct.getId()) {
	            return new ResponseEntity<>("The product ID in the request body does not match the URL.", HttpStatus.CONFLICT);
	        }

	        // Update the product
	        service.setProductById(updateProduct, imageFile);
	        return new ResponseEntity<>("Product updated successfully.", HttpStatus.CREATED);
	        
		}
		 catch (Exception e) {
			 return new ResponseEntity<>("An error occurred while updating the product.", HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	        
	}
	

	// Delete Product by product id
	@DeleteMapping("/product/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id) {
		
		try {
			// Retrieve the existing product by ID
	        Product existingProduct = service.getProductById(id);

	        if (existingProduct == null) {
	            return new ResponseEntity<>("No product found with the specified ID.", HttpStatus.NOT_FOUND);
	        }
	        
	        // Delete the product
			service.deleteProductById(id);
			return new ResponseEntity<>("Product deleted successfully.", HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>("An error occurred while deleting the product.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	
		
}
