package com.project.pojos;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product 
{
	private Integer id;
	private Integer gtin;
	private String name;
	private ProductCategory category;
	private ProductMaterial material;
	private ProductShape shape;
	private ProductFinish finish;
	private byte[] image;
	private String description;
	private double price;
	private Set<Order> orders = new HashSet<>();
	private User userVendor;
	
	public Product() {
		System.out.println(getClass().getName()+"...created");
	}

	public Product(Integer gtin, String name, ProductCategory category, ProductMaterial material, ProductShape shape,
			ProductFinish finish, String description, double price) {
		super();
		this.gtin = gtin;
		this.name = name;
		this.category = category;
		this.material = material;
		this.shape = shape;
		this.finish = finish;
		this.description = description;
		this.price = price;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(nullable = false, unique = true)
	public Integer getGtin() {
		return gtin;
	}

	public void setGtin(Integer gtin) {
		this.gtin = gtin;
	}

	@Column(length = 30, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Enumerated(EnumType.STRING)
	@Column(length = 20, nullable = false)
	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	@Enumerated(EnumType.STRING)
	@Column(length = 20, nullable = false)
	public ProductMaterial getMaterial() {
		return material;
	}

	public void setMaterial(ProductMaterial material) {
		this.material = material;
	}

	@Enumerated(EnumType.STRING)
	@Column(length = 20, nullable = false)
	public ProductShape getShape() {
		return shape;
	}

	public void setShape(ProductShape shape) {
		this.shape = shape;
	}

	@Enumerated(EnumType.STRING)
	@Column(length = 20, nullable = false)
	public ProductFinish getFinish() {
		return finish;
	}

	public void setFinish(ProductFinish finish) {
		this.finish = finish;
	}

	@Lob
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Column(length = 50)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(columnDefinition = "double(5,2)", nullable = false)
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	@ManyToMany(mappedBy = "products", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	@ManyToOne
	@JoinColumn(name = "vendor_id")
	public User getUserVendor() {
		return userVendor;
	}

	public void setUserVendor(User userVendor) {
		this.userVendor = userVendor;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", gtin=" + gtin + ", name=" + name + ", category=" + category + ", material="
				+ material + ", shape=" + shape + ", finish=" + finish + ", image=" + Arrays.toString(image)
				+ ", description=" + description + ", price=" + price + "]";
	}
	
}
