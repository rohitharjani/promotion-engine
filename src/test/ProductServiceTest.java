package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import constants.ServiceConstants;
import models.Product;
import service.IProductService;
import service.ProductService;

public class ProductServiceTest {

	private IProductService productService = new ProductService();

	@Test
	public void testCreateProductA() {
		Product product = productService.createProduct(ServiceConstants.PRODUCT_A);
		assertNotNull(product);
		assertEquals(ServiceConstants.PRODUCT_A, product.getProductId());
	}

	@Test
	public void testCreateProductB() {
		Product product = productService.createProduct(ServiceConstants.PRODUCT_B);
		assertNotNull(product);
		assertEquals(ServiceConstants.PRODUCT_B, product.getProductId());
	}

	@Test
	public void testGetTotalPriceScenarioA() {
		Product productA = productService.createProduct(ServiceConstants.PRODUCT_A);
		Product productB = productService.createProduct(ServiceConstants.PRODUCT_B);
		Product productC = productService.createProduct(ServiceConstants.PRODUCT_C);
		List<Product> productList = new ArrayList<>();
		productList.add(productA);
		productList.add(productB);
		productList.add(productC);
		int totalPrice = productService.getTotalPrice(productList);
		assertNotNull(totalPrice);
		assertEquals(100, totalPrice);
	}

	@Test
	public void testGetTotalPriceScenarioB() {
		List<Product> productList = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			productList.add(productService.createProduct(ServiceConstants.PRODUCT_A));
			productList.add(productService.createProduct(ServiceConstants.PRODUCT_B));
		}
		productList.add(productService.createProduct(ServiceConstants.PRODUCT_C));
		int totalPrice = productService.getTotalPrice(productList);
		assertNotNull(totalPrice);
		assertEquals(370, totalPrice);
	}

	@Test
	public void testGetTotalPriceScenarioC() {
		List<Product> productList = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			productList.add(productService.createProduct(ServiceConstants.PRODUCT_A));
		}
		for (int i = 0; i < 5; i++) {
			productList.add(productService.createProduct(ServiceConstants.PRODUCT_B));
		}
		productList.add(productService.createProduct(ServiceConstants.PRODUCT_C));
		productList.add(productService.createProduct(ServiceConstants.PRODUCT_D));
		int totalPrice = productService.getTotalPrice(productList);
		assertNotNull(totalPrice);
		assertEquals(280, totalPrice);
	}
}
