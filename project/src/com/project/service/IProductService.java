package com.project.service;

import com.project.pojos.Product;

public interface IProductService {
	Boolean saveOrUpdateProduct(Product p);
	Product getProductById(int gtin);
	Boolean deleteProductById(int productId);
}
