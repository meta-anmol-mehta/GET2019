package com.metacube.training.question1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class EmployeeCollectionTest {

	EmployeeCollection employeeCollection = new EmployeeCollection();

	@Test
	public void testSortById()  {
		employeeCollection.addEmployee(1, "dhruv", "gwalior");
		employeeCollection.addEmployee(2, "vijay", "jaipur");
		employeeCollection.addEmployee(4, "anmol", "bikaner");
		employeeCollection.addEmployee(5, "saurabh", "ajmer");
		employeeCollection.addEmployee(3, "ronak", "agra");
		employeeCollection.sortById();

		List<Employee> actualList = employeeCollection.getEmployeeList();
		List<Employee> expectedResult = new ArrayList<Employee>();
		expectedResult.add(new Employee(1, "dhruv", "gwalior"));
		expectedResult.add(new Employee(2, "vijay", "jaipur"));
		expectedResult.add(new Employee(3, "ronak", "agra"));
		expectedResult.add(new Employee(4, "anmol", "bikaner"));
		expectedResult.add(new Employee(5, "saurabh", "ajmer"));

		String actualString = actualList.toString();
		String expectedString = expectedResult.toString();
		assertEquals(expectedString, actualString);

	}

	@Test
	public void testSortByName()  {
		employeeCollection.addEmployee(1, "dhruv", "gwalior");
		employeeCollection.addEmployee(2, "vijay", "jaipur");
		employeeCollection.addEmployee(4, "anmol", "bikaner");
		employeeCollection.addEmployee(5, "saurabh", "ajmer");
		employeeCollection.addEmployee(3, "ronak", "agra");
		employeeCollection.sortByName();
		List<Employee> actualList = employeeCollection.getEmployeeList();
		
		List<Employee> expectedResult = new ArrayList<Employee>();
		expectedResult.add(new Employee(4, "anmol", "bikaner"));
		expectedResult.add(new Employee(1, "dhruv", "gwalior"));
		expectedResult.add(new Employee(3, "ronak", "agra"));
		expectedResult.add(new Employee(5, "saurabh", "ajmer"));
		expectedResult.add(new Employee(2, "vijay", "jaipur"));

		String actualString = actualList.toString();
		String expectedString = expectedResult.toString();
		assertEquals(expectedString, actualString);

	}

	@Test
	public void testDuplicateId()  {
		assertEquals(true,
				employeeCollection.addEmployee(1, "dhruv", "gwalior"));
		assertEquals(true, employeeCollection.addEmployee(4, "anmol", "bikaner"));
		assertEquals(true, employeeCollection.addEmployee(3, "ronak", "agra"));
		assertEquals(false,
				employeeCollection.uniqueId(new Employee(3, "ronak", "agra")));
	}

	@Test(expected = AssertionError.class)
	public void testInvalidId()  {
		employeeCollection.addEmployee(1, "saurabh", "gwalior");
		employeeCollection.addEmployee(0, "anmol", "jaipur");

	}

	@Test(expected = AssertionError.class)
	public void testInvalidName() 
	{
		employeeCollection.addEmployee(1, "saurabh", "gwalior");
		employeeCollection.addEmployee(0, null, "jaipur");

	}

	@Test(expected = AssertionError.class)
	public void testInvalidAddress()  {
		employeeCollection.addEmployee(1, "saurabh", "gwalior");
		employeeCollection.addEmployee(0, "anmol", null);

	}

	
}
