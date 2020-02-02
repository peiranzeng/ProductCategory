package com.product.category.productCategory.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.product.category.productCategory.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{
	
	public List<Product> findByCategory(String category);
	
	public List<Product> findAllBy(TextCriteria criteria);
	
}
