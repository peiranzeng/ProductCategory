package com.product.category.productCategory.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.product.category.productCategory.model.Product;
import com.product.category.productCategory.service.ProductServiceImpl;

@RestController
@RequestMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
	
	@Autowired
	ProductServiceImpl productService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Resource<Product>> getProduct(@PathVariable("id") String id) {

		LOGGER.debug("Fetching Product with id " + id);
		
		
		Optional<Product> productTemp = productService.findOne(id);
		if (!productTemp.isPresent()) {
			LOGGER.debug("Product with id " + id + " not found");
			return new ResponseEntity<Resource<Product>>(HttpStatus.NOT_FOUND);
		}
		
		Product product = productTemp.get();
		Resource<Product> productRes = new Resource<Product>(product,new Link[]{linkTo(methodOn(ProductController.class).getProduct(product.getId())).withSelfRel()
				,linkTo(ProductController.class).slash("productImg").slash(product.getImgURL()).withRel("imgUrl")
		});
		return new ResponseEntity<Resource<Product>>(productRes, HttpStatus.OK);
	}
	

	@GetMapping(params = "category")
	public ResponseEntity<Resources<Resource<Product>>> getProductsByCategory(@RequestParam("category") String category){
		
		List<Product> products =
	            productService.findByCategory(category);
	        Link links[] = { };
	        if (products.isEmpty()) {
	            return new ResponseEntity<Resources<Resource<Product>>>(
	                HttpStatus.NOT_FOUND);
	        }
	        List<Resource<Product>> list = new ArrayList<Resource<Product>>();
	        addLinksToProduct(products, list);
	        Resources<Resource<Product>> productRes =
	            new Resources<Resource<Product>>(list, links);
	        return new ResponseEntity<Resources<Resource<Product>>>(
	            productRes, HttpStatus.OK);
		
	}
	
	@GetMapping(params = "text")
	public ResponseEntity<Resources<Resource<Product>>> findProductsByText(@RequestParam("text") String text){
		
		List<Product> products =
	            productService.findByText(text);
	        Link links[] = { };
	        if (products.isEmpty()) {
	            return new ResponseEntity<Resources<Resource<Product>>>(
	                HttpStatus.NOT_FOUND);
	        }
	        List<Resource<Product>> list = new ArrayList<Resource<Product>>();
	        addLinksToProduct(products, list);
	        Resources<Resource<Product>> productRes =
	            new Resources<Resource<Product>>(list, links);
	        return new ResponseEntity<Resources<Resource<Product>>>(
	            productRes, HttpStatus.OK);
		
	}
	
	private void addLinksToProduct(List<Product> products, List<Resource<Product>> list) {
		for (Product product : products) {
			list.add(new Resource<Product>(product,
					new Link[]{linkTo(methodOn(ProductController.class).getProduct(product.getId())).withSelfRel()
							,linkTo(ProductController.class).slash("productImg").slash(product.getImgURL()).withRel("imgUrl")
					}));
		}
	}
	
}
