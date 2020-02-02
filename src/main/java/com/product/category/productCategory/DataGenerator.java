package com.product.category.productCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.product.category.productCategory.model.Product;
import com.product.category.productCategory.repository.ProductRepository;


@Service
@Profile("!prod") 
public class DataGenerator implements CommandLineRunner {

	@Autowired
	ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Product product1 = 
				new Product("Cook Book", "102", "Cook book version2", "this is a book", "//", 10.0, "book", 2);
		
		Product product2 = 
				new Product("Training Book", "103", "Training book version3", "this is a training book", "//", 12.0, "book", 3);
		
		Product product3 = 
				new Product("Movie", "104", "American Movie", "this is a movie", "//", 13.0, "movie", 4);
		
		Product product4 = 
				new Product("Toy", "105", "American Toy", "this is a Toy", "//", 14.0, "Toy", 2);
		
		Product product5 = 
				new Product("Bob", "106", "American Movie", "this is a movie", "//", 13.0, "movie", 6);
		
		
		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);
		productRepository.save(product4);
		productRepository.save(product5);
		
		
	}
	
}
