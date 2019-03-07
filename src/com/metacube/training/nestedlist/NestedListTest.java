package com.metacube.training.nestedlist;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import org.json.simple.JsonObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;

public class NestedListTest {
	
	@Test
	public void testSum() throws FileNotFoundException, IOException, org.json.simple.parser.ParseException  {

		File file = new File(
				"C://Users/anmol/Downloads/DS-Assignment-1/src/input.json.txt");

		JSONParser parser = new JSONParser();
		Object object;
		
				object = parser.parse(new FileReader(file));
				JsonObject JsonObject = (JsonObject) object;

				NestedListOperation nestedOperations = new NestedListOperation(
						JsonObject);
				nestedOperations.createNestedList();

				long result = nestedOperations.sumOfAllValues();
				assertEquals(result, 207);
			
		
	}

	@Test
	public void testLargest() throws org.json.simple.parser.ParseException, FileNotFoundException, IOException  {
		File file = new File(
				"C://Users/anmol/Downloads/DS-Assignment-1/src/input.json.txt");

		JSONParser parser = new JSONParser();
		Object object;
		
			object = parser.parse(new FileReader(file));
			JsonObject JsonObject = (JsonObject) object;

			NestedListOperation nestedOperations = new NestedListOperation(
					JsonObject);
			nestedOperations.createNestedList();
			long result = nestedOperations.largestValue();
			assertEquals(result, 99);
		
		
	}

	@Test
	public void testSearchPositive() throws FileNotFoundException, IOException, org.json.simple.parser.ParseException  {
		File file = new File(
				"C://Users/anmol/Downloads/DS-Assignment-1/src/input.json.txt");

		JSONParser parser = new JSONParser();
		Object object;
		
			object = parser.parse(new FileReader(file));
			JsonObject JsonObject = (JsonObject) object;

			NestedListOperation nestedOperations = new NestedListOperation(
					JsonObject);
			nestedOperations.createNestedList();
			boolean result = nestedOperations.searchValue(45);
			assertEquals(result, true);
		
		
	}

	@Test
	public void testSearchNegative() throws FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException {
		File file = new File(
				"C://Users/anmol/Downloads/DS-Assignment-1/src/input.json.txt");

		JSONParser parser = new JSONParser();
		Object object = parser.parse(new FileReader(file));
		JsonObject JsonObject = (JsonObject) object;

		NestedListOperation nestedOperations = new NestedListOperation(
				JsonObject);
		nestedOperations.createNestedList();
		boolean result = nestedOperations.searchValue(-8);
		assertEquals(result, false);
	}

	@Test
	public void testGetValuePositive() throws FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException  {
		File file = new File(
				"C://Users/anmol/Downloads/DS-Assignment-1/src/input.json.txt");

		JSONParser parser = new JSONParser();
		Object object = parser.parse(new FileReader(file));
		JsonObject JsonObject = (JsonObject) object;

		NestedListOperation nestedOperations = new NestedListOperation(
				JsonObject);
		nestedOperations.createNestedList();
		long result = (long) nestedOperations.getValue("thh");
		assertEquals(result, 1);
	}

	@Test(expected = AssertionError.class)
	public void testGetValueNegativeOnlyTPresent() throws FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException {
		File file = new File(
				"C://Users/anmol/Downloads/DS-Assignment-1/src/input.json.txt");

		JSONParser parser = new JSONParser();
		Object object = parser.parse(new FileReader(file));
		JsonObject JsonObject = (JsonObject) object;

		NestedListOperation nestedOperations = new NestedListOperation(
				JsonObject);
		nestedOperations.createNestedList();
		long result = (long) nestedOperations.getValue("t");
	}

	@Test
	public void testGetValuePositiveIgnoreCase() throws FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException {
		File file = new File(
				"C://Users/anmol/Downloads/DS-Assignment-1/src/input.json.txt");

		JSONParser parser = new JSONParser();
		Object object = parser.parse(new FileReader(file));
		JsonObject JsonObject = (JsonObject) object;

		NestedListOperation nestedOperations = new NestedListOperation(JsonObject);
		nestedOperations.createNestedList();
		long result = (long) nestedOperations.getValue("THH");
		assertEquals(result, 1);
	}

	
	@Test(expected = NullPointerException.class)
	public void testGetValueNullString() throws org.json.simple.parser.ParseException, FileNotFoundException, IOException {
		File file = new File(
				"C://Users/anmol/Downloads/DS-Assignment-1/src/input.json.txt");

		JSONParser parser = new JSONParser();
		Object object;
		
			object = parser.parse(new FileReader(file));
			JsonObject JsonObject = (JsonObject) object;

			NestedListOperation nestedOperations = new NestedListOperation(
					JsonObject);
			nestedOperations.createNestedList();
			long result = (long) nestedOperations.getValue(null);
		
		

	}

	
}
