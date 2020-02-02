package com.product.category.productCategory.model;

import lombok.Data;

@Data
public class LineItem { 
	
	private String productId;

	private Integer quantity;

	private Double price;
}
