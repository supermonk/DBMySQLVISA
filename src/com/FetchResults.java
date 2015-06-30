/*
 * 	FetchResults.java
 *	Created on Jun 29, 2015, 9:11:42 PM with @version 1.0
 *	@author narendrabidari
 * 	Service Layer
 */
package com;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import DAO.EmployeeDAO;
import DO.EmployeeDO;

public class FetchResults {

	/**
	 * 
	 * @return Map of Highest Salaried employee per Department
	 */
	public HashMap<String, EmployeeDO> highestSalaryList(){
		EmployeeDAO dao = new EmployeeDAO();
		HashMap<String, EmployeeDO> map = new HashMap<String, EmployeeDO>();
		try {
			List<EmployeeDO> list = dao.joinTableEmployeeSalary();
			for(EmployeeDO e : list)
				update(e,map);

		} catch (SQLException e) {
			//  log the errors
			e.printStackTrace();
		} catch (Exception e) {
			//  log the errors
			e.printStackTrace();
		}

		return map;
	}

	/**
	 * retains only the highest employee per dept
	 * @param emp
	 * @param map
	 */
	public void update (EmployeeDO emp, HashMap<String, EmployeeDO> map){
		EmployeeDO max = map.get(emp.getDept());
		if(max!=null){
			if(emp.getSalary()> max.getSalary()){
				map.put(emp.getDept(), emp);
			}
		}else{
			map.put(emp.getDept(), emp);
		}
	}

}
