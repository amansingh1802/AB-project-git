package com.project.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.pojos.Product;

@Repository
@Transactional
public class ProductDaoImpl implements IProductDao {
	
	@Autowired
	private SessionFactory sf;

	@Override
	public Boolean saveOrUpdateProduct(Product p) {
		try {
			sf.getCurrentSession().saveOrUpdate(p);
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Product getProductById(int gtin) {
		try {
			return sf.getCurrentSession().get(Product.class, gtin);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean deleteProductById(int productId) {
		try {
			sf.getCurrentSession().delete(this.getProductById(productId));
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}	
}
