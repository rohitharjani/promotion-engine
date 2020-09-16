package main;

import java.util.ArrayList;
import java.util.List;

import constants.ServiceConstants;
import models.Product;
import service.IProductService;
import service.ProductService;

public class MainApplication {

	public static void main(String[] args) {
		IProductService productService = new ProductService();
		Product productA = productService.createProduct(ServiceConstants.PRODUCT_A);
		Product productB = productService.createProduct(ServiceConstants.PRODUCT_B);
		Product productC = productService.createProduct(ServiceConstants.PRODUCT_C);
		List<Product> productList = new ArrayList<>();
		productList.add(productA);
		productList.add(productB);
		productList.add(productC);
		int totalPrice = productService.getTotalPrice(productList);
		System.out.println("Total Price: "+ totalPrice);
		

	}

}
