package com.finzly.springboot.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class ConnectionProvider {

	private static ConnectionProvider getCon;
	private static String url;
	private static String username;
	private static String password;
	private static String driver;

	private ConnectionProvider() {
		url = "jdbc:mysql://localhost:3306/sakila";
		username = "root";
		password = "arjunjai5525";
		driver = "com.mysql.cj.jdbc.Driver";
	}

	public static Connection getConnection() {
		try {
			getCon = new ConnectionProvider();
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, username, password);
			return con;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
