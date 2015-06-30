/*
 * 	CreateDatabase.java
 *	Created on Jun 29, 2015, 8:07:11 PM with @version 1.0
 *	@author narendrabidari
 * 	Add description of file
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

import Interface.Connections;

public class MYSQLConnection implements Connections {

	//Establish the database network path  to mysql
	Connection conn = null;
	public static final String url = "jdbc:mysql://localhost:3306/";
	public static final String dbName = "employees";
	public static final String driver = "com.mysql.jdbc.Driver";
	public static final String userName = "root";
	public static final String password = "root";
	//establish the  connection
	@Override
	public Connection getConnection() throws Exception {
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url+dbName,userName,password);
		} catch (Exception e) {
			// log
			System.out.println("Unable to Connect to server");
			throw e;
		}
		return conn;
		// 		If we have to do the pooling way.
		//		 MysqlDataSource dataSource = new MysqlDataSource();
		//		 dataSource.setUrl(url);
		//		 dataSource.setDatabaseName(mySQL);
		//		 dataSource.setUser(userName);
		//		 dataSource.setPassword(password);

		
	}

}
