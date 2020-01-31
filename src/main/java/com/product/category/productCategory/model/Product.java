package com.product.category.productCategory.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "Product")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Product {
	
	@Id
	private String id;
	private String name;
	private String code;
	private String title;
	private String description;
	private String imgURL;
	private Double price;
	private String category;
	private int quantity;
	
}
