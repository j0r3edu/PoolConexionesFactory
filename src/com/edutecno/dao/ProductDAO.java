package com.edutecno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.entity.Product;
import com.edutecno.factorymethod.DBFactory;
import com.edutecno.factorymethod.IDBAdapter;

public class ProductDAO {

	private IDBAdapter dbAdapter;
	
	public ProductDAO() {
		dbAdapter = DBFactory.getDefaultDBAdapter();
	}
	
	public List<Product> findAllProducts() throws SQLException {
		
		Connection connection = dbAdapter.getConnection();
		
		//logica
		List<Product> productList = new ArrayList<Product>();
		
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM productos");
			ResultSet results = stmt.executeQuery();
			
			while(results.next()) {
				
				productList.add(new Product(results.getLong(1), results.getString(2), results.getDouble(3)));
			}
			return productList;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}finally {
			connection.close();
		}
	}
	
	public boolean saveProduct(Product product) {
		
		Connection connection = dbAdapter.getConnection();
		
		try {
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO productos (idProductos, productName, productPrice) VALUES (?,?,?)");
			stmt.setLong(1, product.getIdProductos());
			stmt.setString(2, product.getProductName());
			stmt.setDouble(3, product.getProductPrice());
			stmt.executeUpdate();
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

	