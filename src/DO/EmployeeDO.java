/*
 * 	EmployeeDO.java
 *	Created on Jun 29, 2015, 7:49:46 PM with @version 1.0
 *	@author narendrabidari
 * 	Add description of file
 */
package DO;
public class EmployeeDO {

	private long employeeid;
	private String name;
	private String dept;
	private double salary;

	public EmployeeDO(long employeeid, String name, String dept){
		this.employeeid = employeeid;
		this.name = name;
		this.dept = dept;

	}

	public EmployeeDO(long employeeid, String name, String dept, double salary){
		this(employeeid,name,dept);
		this.salary = salary;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (employeeid ^ (employeeid >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDO other = (EmployeeDO) obj;
		if (employeeid != other.employeeid)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EmployeeDO [employeeid=" + employeeid + ", name=" + name + ", dept=" + dept
				+ "]";
	}
	/**
	 * @return the employeeid
	 */
	public long getId() {
		return employeeid;
	}
	/**
	 * @param employeeid the employeeid to set
	 */
	public void setId(long employeeid) {
		this.employeeid = employeeid;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the dept
	 */
	public String getDept() {
		return dept;
	}
	/**
	 * @param dept the dept to set
	 */
	public void setDept(String dept) {
		this.dept = dept;
	}




	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}




	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}



}
