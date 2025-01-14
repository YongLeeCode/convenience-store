package com.convenience.convenience;

import com.convenience.convenience.controller.ProductController;
import com.convenience.convenience.repository.ListProductRepository;
import com.convenience.convenience.service.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConvenienceApplication {

	public static void main(String[] args) {

		//		ListProductRepository productRepository = new ListProductRepository();
		//		ProductService productService = new ProductService(productRepository, new ModelMapper());
		//		ProductController productController = new ProductController(productService);

		ApplicationContext context = SpringApplication.run(ConvenienceApplication.class, args);
		ProductController productController = context.getBean(ProductController.class);


		productController.findProducts(null).forEach(product -> {
			System.out.printf("Name: %s, Price: %d, Promotion: %s, Quantity: %d%n",
					product.getName(), product.getPrice(),
					product.getPromotion(), product.getQuantity());
		});

		//		SpringApplication.run(ConvenienceApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
				.setFieldAccessLevel(AccessLevel.PRIVATE)
				.setFieldMatchingEnabled(true);
		return modelMapper;
	}

}
