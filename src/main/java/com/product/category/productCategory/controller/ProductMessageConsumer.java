package com.product.category.productCategory.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.product.category.productCategory.model.LineItem;
import com.product.category.productCategory.service.ProductService;

@Component
public class ProductMessageConsumer {

	private static final Logger logger = LoggerFactory.getLogger(ProductMessageConsumer.class);
	
	@Autowired
	ProductService productService;
	
	@RabbitListener(queues = "makeOrder.queue")
	public void receivedMessage(List<LineItem> products) {
		logger.info("Receive Message From Order Service: " + products);
		
		for(LineItem item : products) {
			
			productService.updateProduct(item);
		}
		
	}
	
}
