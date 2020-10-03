package com.codigorupestre.jersey.factorymethod;

import java.sql.Connection;

public interface IDBAdapter {
	
	
	public Connection getConnection();

}
