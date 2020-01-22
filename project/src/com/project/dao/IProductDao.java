package com.project.dao;

import com.project.pojos.Product;

public interface IProductDao {
	Boolean saveOrUpdateProduct(Product p);
	Product getProductById(int gtin);
	Boolean deleteProductById(int productId);
}
