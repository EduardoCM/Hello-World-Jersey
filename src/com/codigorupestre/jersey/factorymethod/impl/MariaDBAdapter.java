package com.codigorupestre.jersey.factorymethod.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.codigorupestre.jersey.factorymethod.IDBAdapter;
import com.codigorupestre.jersey.factorymethod.util.PropertiesUtil;

public class MariaDBAdapter implements IDBAdapter {

	private static final String DB_PROPERTIES = "MariaDB.properties";
	
	private static final String URL = "url";

    //Propiedades de los archivos properties
	//private static final String DB_HOST_PROP = "host";
	//private static final String DB_PORT_PROP = "port";
	//private static final String DB_USER_PROP = "user";
	//private static final String DB_PASSWORD_PROP = "password"
	//private static final String DB_NAME_PROP = "database";
    
   
    

    static {
        //Bloque para registrar el Driver de MySQL
        try {
            new org.mariadb.jdbc.Driver();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        Properties prop = PropertiesUtil.loadProperty(DB_PROPERTIES);
       /*
        String host = prop.getProperty(DB_HOST_PROP);
        String port = prop.getProperty(DB_PORT_PROP);
        String db = prop.getProperty(DB_NAME_PROP);
        String user = prop.getProperty(DB_USER_PROP);
        String password = prop.getProperty(DB_PASSWORD_PROP);
        String connectionString = "jdbc:mariadb://" + host + ":" + port + "/" + db + "?user=" + user + "&password=" + password;
        System.out.println("ConnectionString ==> " + connectionString);
        */
        
        return prop.getProperty(URL);
    }
	
}
