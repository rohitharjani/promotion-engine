package service;

import java.util.List;

import constants.ServiceConstants;
import exception.InvalidProductException;
import models.Product;

public class ProductService implements IProductService {

	@Override
	public Product createProduct(String productId) {
		Product product = new Product();
		product.setProductId(productId);
		switch (productId) {
		case ServiceConstants.PRODUCT_A:
			product.setPrice(50);
			break;
		case ServiceConstants.PRODUCT_B:
			product.setPrice(30);
			break;
		case ServiceConstants.PRODUCT_C:
			product.setPrice(20);
			break;
		case ServiceConstants.PRODUCT_D:
			product.setPrice(15);
			break;
		default:
			throw new InvalidProductException(ServiceConstants.INAVALID_PRODUCT_TYPE);
		}
		return product;
	}

	@Override
	public int getTotalPrice(List<Product> products) {
		int countA = 0;
		int countB = 0;
		int countC = 0;
		int countD = 0;
		int totalPriceOfA = 0;
		int totalPriceOfB = 0;
		int totalPriceOfC = 0;
		int totalPriceOfD = 0;
		for (Product product : products) {
			switch (product.getProductId()) {
			case ServiceConstants.PRODUCT_A:
				countA++;
				break;
			case ServiceConstants.PRODUCT_B:
				countB++;
				break;
			case ServiceConstants.PRODUCT_C:
				countC++;
				break;
			case ServiceConstants.PRODUCT_D:
				countD++;
				break;
			default:
				throw new InvalidProductException(ServiceConstants.INAVALID_PRODUCT_TYPE);
			}
		}
		totalPriceOfA = (countA / 3) * 130 + (countA % 3 * getProductPrice(ServiceConstants.PRODUCT_A));
		totalPriceOfB = (countB / 2) * 45 + (countB % 2 * getProductPrice(ServiceConstants.PRODUCT_B));
		if (countC == 1 && countD == 1) {
			totalPriceOfD = ServiceConstants.THIRTY;
		} else {
			totalPriceOfC = (countC * getProductPrice(ServiceConstants.PRODUCT_C));
			totalPriceOfD = (countD * getProductPrice(ServiceConstants.PRODUCT_D));
		}
		return (totalPriceOfA + totalPriceOfB + totalPriceOfC + totalPriceOfD);
	}

	private int getProductPrice(String productId) {
		if (ServiceConstants.PRODUCT_A.equalsIgnoreCase(productId)) {
			return ServiceConstants.FIFTY;
		} else if (ServiceConstants.PRODUCT_B.equalsIgnoreCase(productId)) {
			return ServiceConstants.THIRTY;
		} else if (ServiceConstants.PRODUCT_C.equalsIgnoreCase(productId)) {
			return ServiceConstants.TWENTY;
		} else if (ServiceConstants.PRODUCT_D.equalsIgnoreCase(productId)) {
			return ServiceConstants.FIFTEEN;
		} else
			throw new InvalidProductException(ServiceConstants.INAVALID_PRODUCT_TYPE);
	}

}
