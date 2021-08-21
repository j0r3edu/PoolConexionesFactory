package com.edutecno.factorymethodimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.edutecno.factorymethod.IDBAdapter;
import com.edutecno.util.PropertiesUtil;

import oracle.jdbc.OracleDriver;

public class OracleDBAdapter implements IDBAdapter {
	
	private static final String DB_PROPERTIES = "com/edutecno/properties/DBOracle.properties";
	private static final String DB_SERVICE_PROP = "service";
	private static final String DB_HOST_PROP = "host";
	private static final String DB_PASSWORD_PROP = "password";
	private static final String DB_PORT_PROP = "port";
	private static final String DB_USER_PROP = "user";
	
	static {
		try {
			new OracleDriver();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

//	@Override
//	public Connection getConnection() {
//		
//		try {
//			String connectionString = createConnectionString();
//			Connection connection = DriverManager.getConnection(connectionString);
//			System.out.println("Clase de conexion ::::::" + connection.getClass().getName());
//			return connection;
//		}catch(Exception ex) {
//			return null;
//		}
//		
//	}
	
	@Override
	public Connection getConnection() {
		Context initContext;
		try {
			initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/ConexionOracle");
			Connection connection = ds.getConnection();
			return connection;
		}catch(Exception ex) {
			return null;
		}
	}
	
	
	
	private String createConnectionString() {
		Properties prop = PropertiesUtil.loadProperty(DB_PROPERTIES);
		String host = prop.getProperty(DB_HOST_PROP);
		String port = prop.getProperty(DB_PORT_PROP);
		String service = prop.getProperty(DB_SERVICE_PROP);
		String user = prop.getProperty(DB_USER_PROP);
		String password = prop.getProperty(DB_PASSWORD_PROP);
		
		String connectionString = "jdbc:oracle:thin:"+user+"/"+password+"@//"+host+":"+port+"/"+service;
		System.out.println("String de conexion:::: " + connectionString);
		return connectionString;
	}

}
