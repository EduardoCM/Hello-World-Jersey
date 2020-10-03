package com.codigorupestre.jersey.factorymethod;

import java.util.Properties;

import com.codigorupestre.jersey.factorymethod.impl.MariaDBAdapter;
import com.codigorupestre.jersey.factorymethod.impl.OracleDBAdapter;
import com.codigorupestre.jersey.factorymethod.util.PropertiesUtil;

public class DBFactory {
	
	private static final String DB_FACTORY_PROPERTY_URL = "DBFactory.properties";
    private static final String DEFAULT_DB_CLASS_PROP = "DB";

    public static IDBAdapter getDBadapter(DBType dbType) {
        switch (dbType) {
            case MariaDB:
                return new MariaDBAdapter();
            case Oracle:
                return new OracleDBAdapter();
            default:
                throw new IllegalArgumentException("Not supported");
        }
    }

    public static IDBAdapter getDefaultDBAdapter() {
        try {
            Properties prop = PropertiesUtil.loadProperty(DB_FACTORY_PROPERTY_URL);
            String defaultDBClass = prop.getProperty(DEFAULT_DB_CLASS_PROP);
            System.out.println("DefaultDBClass ==> " + defaultDBClass);
            return (IDBAdapter) Class.forName(defaultDBClass).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
