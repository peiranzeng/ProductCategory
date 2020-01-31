package com.product.category.productCategory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.product.category.productCategory.model.Product;
import com.product.category.productCategory.repository.ProductRepository;

public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Product> findByCategory(String category) {
		
		return productRepository.findByCategory(category);
		
	}

	@Override
	public Optional<Product> findOne(String id) {
		
		return productRepository.findById(id);
	}

	

}
