package com.product.category.productCategory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

import com.product.category.productCategory.model.LineItem;
import com.product.category.productCategory.model.Product;
import com.product.category.productCategory.repository.ProductRepository;

@Service
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

	@Override
	public List<Product> findByText(String text) {
		
		TextCriteria textSearch = TextCriteria.forDefaultLanguage().matching(text);
		
		return productRepository.findAllBy(textSearch);
	}

	@Override
	public void updateProduct(LineItem item) {
		
		String id = item.getProductId();
		
		Product product = productRepository.findById(id).get();
		
		product.setQuantity(product.getQuantity() - item.getQuantity());
		
		productRepository.save(product);
		
	}

	

}
