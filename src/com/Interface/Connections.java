/*
 * 	Connections.java
 *	Created on Jun 29, 2015, 8:12:54 PM with @version 1.0
 *	@author narendrabidari
 */
package com.Interface;
import java.sql.Connection;
public interface Connections {
	public Connection getConnection() throws Exception;
}
