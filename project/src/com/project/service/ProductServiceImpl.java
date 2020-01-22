package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.IProductDao;
import com.project.pojos.Product;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductDao pdao;
	
	public ProductServiceImpl() {
		System.out.println(getClass().getName());
	}
	
	@Override
	public Boolean saveOrUpdateProduct(Product p) {
		return pdao.saveOrUpdateProduct(p);
	}

	@Override
	public Product getProductById(int gtin) {
		return pdao.getProductById(gtin);
		
	}

	@Override
	public Boolean deleteProductById(int productId) {
		return pdao.deleteProductById(productId);
	}
}
