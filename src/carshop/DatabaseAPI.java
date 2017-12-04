/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseAPI {

	public Connection connection;

	public DatabaseAPI() throws SQLException, ClassNotFoundException {
		// Load the JDBC driver
		Class.forName("com.mysql.jdbc.Driver");
	}

	public void startConnection() throws SQLException {
		 connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/carshop?autoReconnect=true&useSSL=false","root","root");

		
	}

	public ResultSet read(String sql) throws SQLException {
		startConnection();
		Statement statement = connection.createStatement();

		// Execute a statement
		ResultSet resultSet = statement.executeQuery(sql);
		
		return resultSet;
	}
	
	public int write(String sql) throws SQLException{
		startConnection();
		Statement statement = connection.createStatement();
		
		int x = statement.executeUpdate(sql);
		connection.close();
		connection = null;
		return x;
	}

	
}