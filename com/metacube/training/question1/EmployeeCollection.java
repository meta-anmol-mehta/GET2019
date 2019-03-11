package com.metacube.training.question1;

import java.util.ArrayList;
import java.util.List;
/**
 * This class is used to add employees and sort them by their id or name
 * 
 * @author admin
 *
 */
public class EmployeeCollection {

	private List<Employee> employeeList;

	public EmployeeCollection() {
		employeeList = new ArrayList<Employee>();
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	/**
	 * Method to add employee to employeeList
	 * 
	 * @param empId
	 * @param name
	 * @param address
	 * @return true if added successfully
	 * @throws AssertionError
	 *             if employee id is negative or zero, or name or address is
	 *             null
	 */
	public boolean addEmployee(int id,String name,String address){
		
		boolean result=false; 
		
		
		if(id>0 && (name!=null &&name.matches("[a-zA-z]+"))&& (address!=null &&name.matches("[a-zA-z]+")) ){
			
			Employee employee=new Employee(id,name,address);
			
			if(uniqueId(employee))
			{
			employeeList.add(employee);
			
			result=true;
			}
			
		}
		else{
			throw new AssertionError("Invalid input");
		}
		return result;
		
	}
	
	
	/**
	 * method to check whether employee already exist or not
	 * @param employee
	 * @return true if id is unique
	 */
	public boolean uniqueId(Employee employee) {

		boolean result = true;
		if(employee.getId()>0 && (employee.getName()!=null &&employee.getName().matches("[a-zA-z]+"))&& (employee.getAddress()!=null &&employee.getAddress().matches("[a-zA-z]+")) ){
		
			for (Employee individualEmployee : employeeList) {
				if (employee.getId() == individualEmployee.getId()) {
					result = false;
					break;
				}
			}
			
		}
		else{
			throw new AssertionError("Invalid input");
		}
		

		return result;
	}

	/**
	 * Method calls compare method of SortById class to sort employees on the
	 * basis of id
	 */

	public List<Employee> sortById() {

		Employee temp;

		for (int i = 0; i < employeeList.size(); ++i) {
			for (int j = i + 1; j < employeeList.size(); ++j) {

				if (employeeList.get(i).getId() > employeeList.get(j).getId()) {

					temp = employeeList.get(i);
					employeeList.set(i, employeeList.get(j));
					employeeList.set(j, temp);

				}

			}
		}

		return employeeList;
	}

	/**
	 * Method calls compare method of SortById class to sort employees on the
	 * basis of name
	 */

	public List<Employee> sortByName() {

		Employee temp;

		for (int i = 0; i < employeeList.size(); ++i) {
			for (int j = i + 1; j < employeeList.size(); ++j) {

				if (employeeList.get(i).getName()
						.compareTo(employeeList.get(j).getName()) > 0) {

					temp = employeeList.get(i);
					employeeList.set(i, employeeList.get(j));
					employeeList.set(j, temp);

				}

			}
		}

		return employeeList;
	}

	@Override
	public String toString() {
		return "EmployeeCollection [employeeList=" + employeeList + "]";
	}
	
	

}
