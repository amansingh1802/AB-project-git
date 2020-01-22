package com.project.pojos;

import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity	
@Table(name = "User")
public class User 
{
	private Integer id;
	private String name, email, password, address, mobileNo, tan, bankAccount, gstNo, regNo;
	private UserRole role;
	private List<Order> orders = new ArrayList<>();
	
	public User() {
		System.out.println(getClass().getName()+"...created");
	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public User(String name, String email, String password, String address, String mobileNo, UserRole role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.mobileNo = mobileNo;
		this.role = role;
	}

	public User(String name, String email, String password, String address, String mobileNo, String tan,
			String bankAccount, String gstNo, String regNo, UserRole role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.mobileNo = mobileNo;
		this.tan = tan;
		this.bankAccount = bankAccount;
		this.gstNo = gstNo;
		this.regNo = regNo;
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 30, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 30, nullable = false, unique = true)
	@Email(message = "Email should be valid")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 20, nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(length = 50, nullable = false)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(length = 11, nullable = false, unique = true)
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Column(length = 20, unique = true)
	public String getTan() {
		return tan;
	}

	public void setTan(String tan) {
		this.tan = tan;
	}

	@Column(length = 20, unique = true)
	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Column(length = 20, unique = true)
	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	@Column(length = 20, unique = true)
	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	@Enumerated(EnumType.STRING)
	@Column(length = 20, nullable = false)
	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
//helper methods
	public void addOrder(Order order){
		this.orders.add(order);
		order.setUser(this);
	}
	public void removeOrder(Order order) {
		this.orders.remove(order);
		order.setUser(null);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", address="
				+ address + ", mobileNo=" + mobileNo + ", tan=" + tan + ", bankAccount=" + bankAccount + ", gstNo="
				+ gstNo + ", regNo=" + regNo + ", role=" + role + "]";
	}

}
