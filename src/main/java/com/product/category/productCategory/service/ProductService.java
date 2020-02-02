package com.product.category.productCategory.service;

import java.util.List;
import java.util.Optional;

import com.product.category.productCategory.model.LineItem;
import com.product.category.productCategory.model.Product;

public interface ProductService {
	
	public List<Product> findByCategory(String category);
	
	public Optional<Product> findOne(String id);
	
	public List<Product> findByText(String text);
	
	public void updateProduct(LineItem item);
}
