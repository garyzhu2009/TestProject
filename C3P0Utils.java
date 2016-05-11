package garytest;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	private static C3P0Utils dbcputils = null;
	private ComboPooledDataSource cpds = null;

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/webissues";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	private C3P0Utils() {
		if (cpds == null) {
			cpds = new ComboPooledDataSource();
		}
		cpds.setUser(USERNAME);
		cpds.setPassword(PASSWORD);
		cpds.setJdbcUrl(URL);
		try {
			cpds.setDriverClass(DRIVER);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		cpds.setInitialPoolSize(3);
		cpds.setMaxIdleTime(20);
		cpds.setMaxPoolSize(5);
		cpds.setMinPoolSize(2);
	}

	public synchronized static C3P0Utils getInstance() {
		if (dbcputils == null)
			dbcputils = new C3P0Utils();
		return dbcputils;
	}

	public Connection getConnection() {
		Connection con = null;
		try {
			con = cpds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
