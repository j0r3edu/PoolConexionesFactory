package com.edutecno.factorymethod;

import java.sql.SQLException;
import java.util.List;

import com.edutecno.dao.ProductDAO;
import com.edutecno.entity.Product;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		//
		Product productoA = new Product(1L, "Producto A", 100);
		Product productoB = new Product(2L, "Producto B", 100);
		
		ProductDAO productDAO = new ProductDAO();
		productDAO.saveProduct(productoA);
		productDAO.saveProduct(productoB);
		
		List<Product> products = productDAO.findAllProducts();
		
		for (Product product : products) {
			System.out.println(product);
		}
	}

}
