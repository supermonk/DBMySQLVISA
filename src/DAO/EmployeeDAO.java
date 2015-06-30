/*
 * 	EmployeeDAO.java
 *	Created on Jun 29, 2015, 8:07:19 PM with @version 1.0
 *	@author narendrabidari
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DO.EmployeeDO;

/**
 * 
 * DAO layer for employee operations
 * @author narendrabidari
 * @version 1.0,Jun 29, 2015
 */
public class EmployeeDAO {

	private static final String JOINES = "SELECT EMPLOYEE.EMPLOYEEID, NAME, DEPT , SALARY.SALARY"
			+ " FROM EMPLOYEE INNER JOIN SALARY on EMPLOYEE.EMPLOYEEID = SALARY.EMPLOYEEID";

	private static final String ADDEMP = "INSERT INTO EMPLOYEE (NAME,DEPT,SALARY)VALUES(?,?,?)";

	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public List<EmployeeDO> joinTableEmployeeSalary() throws SQLException,Exception{
		Connection mysqlConn = new MYSQLConnection().getConnection();
		PreparedStatement stmt = null;
		List<EmployeeDO> list = null;
		try{
			stmt = mysqlConn.prepareStatement(JOINES);
			ResultSet rs = stmt.executeQuery();
			list = new ArrayList<EmployeeDO>();
			while(rs.next()){
				EmployeeDO emp = new EmployeeDO(rs.getLong("employeeid"),rs.getString("name"),rs.getString("dept"),rs.getDouble("salary"));
				list.add(emp);
			}
		}catch(SQLException se){
			throw se;
		}catch(Exception e){
			throw e;
		}finally{ 
			mysqlConn.close();
		} 
		return list;
	}


	/**
	 *  to add the employee details	
	 * @param emp
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public Boolean addEmployee(EmployeeDO emp) throws SQLException,Exception
	{

		Connection mysqlConn = new MYSQLConnection().getConnection();
		PreparedStatement stmt = null;

		try{
			stmt = mysqlConn.prepareStatement(ADDEMP);
			stmt.setString (2, emp.getName());
			stmt.setString (3, emp.getDept());
			stmt.setDouble(4, emp.getSalary());
			stmt.executeUpdate();
			 

		}catch(SQLException se){
			throw se;
		}catch(Exception e){
			throw e;
		}finally{ 
			mysqlConn.close();
		} 


		return true;
	}


}
