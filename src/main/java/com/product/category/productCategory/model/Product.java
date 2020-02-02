package com.product.category.productCategory.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@Getter @Setter @NoArgsConstructor
public class Product {
	
	@Id
	private String id;
	@TextIndexed
	private String name;
	private String code;
	@TextIndexed
	private String title;
	private String description;
	private String imgURL;
	private Double price;
	@TextIndexed
	private String category;
	private int quantity;
	
	
	public Product(String name, String code, String title, String description, String imgURL, Double price,
			String category, int quantity) {
		super();
		this.name = name;
		this.code = code;
		this.title = title;
		this.description = description;
		this.imgURL = imgURL;
		this.price = price;
		this.category = category;
		this.quantity = quantity;
	}
	
}
