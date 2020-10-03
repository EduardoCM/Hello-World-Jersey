package com.codigorupestre.jersey.factorymethod.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.codigorupestre.jersey.factorymethod.IDBAdapter;
import com.codigorupestre.jersey.factorymethod.util.PropertiesUtil;

import oracle.jdbc.driver.OracleDriver;

public class OracleDBAdapter implements IDBAdapter {

	private static final String properties = "OracleDB.properties";

	private static final String URL = "url";

	

	static {
		new OracleDriver();
	}

	@Override
	public Connection getConnection() {
		try {
			String connectionString = createConnectionString();
			Connection connection = DriverManager.getConnection(connectionString);
			System.out.println("Connection class ==> " + connection.getClass().getName());
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private String createConnectionString() {
		Properties prop = PropertiesUtil.loadProperty(properties);
		
		
		return prop.getProperty(URL);
	}

}
