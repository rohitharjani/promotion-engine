package service;

import java.util.List;

import models.Product;

public interface IProductService {

	Product createProduct(String productId);
	int getTotalPrice(List<Product> products);
}
