package com.edutecno.entity;

public class Product {

	private Long idProductos;
	private String productName;
	private double productPrice;
	
	public Product(Long idProductos, String productName, double productPrice) {
		super();
		this.idProductos = idProductos;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public Long getIdProductos() {
		return idProductos;
	}

	public void setIdProductos(Long idProductos) {
		this.idProductos = idProductos;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product [idProductos=" + idProductos + ", productName=" + productName + ", productPrice=" + productPrice
				+ "]";
	}
	
	
	
	
	
	
}
