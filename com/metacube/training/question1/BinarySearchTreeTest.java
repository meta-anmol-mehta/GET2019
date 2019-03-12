package com.metacube.training.question1;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

public class BinarySearchTreeTest {

File filename =  new File("C:/Users/admin/Desktop/Assignment/DS-Assignment-4/src/com/metacube/training/question1/input.json.txt");
	
	@Test
	public void testGetValue() throws FileNotFoundException, IOException, ParseException  {
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(new FileReader(filename));
		BinarySearchTree<String> bst = new BinarySearchTree<String>(obj);
		String val = bst.getValue("hi");
		assertEquals("hello", val);

	}

	@Test
	public void testGetValueIgnoreCase() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(new FileReader(filename));
		BinarySearchTree<String> bst = new BinarySearchTree<String>(obj);
		String val = bst.getValue("HI");
		assertEquals("hello", val);

	}

	@Test(expected = AssertionError.class)
	public void testGetValueInvalidEntry()
			throws ParseException, FileNotFoundException, IOException {
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(new FileReader(filename));
		BinarySearchTree<String> bst = new BinarySearchTree<String>(obj);
		String val = bst.getValue("");

	}

	@Test
	public void testSortOrder() throws  FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(new FileReader(filename));
		BinarySearchTree<String> bst = new BinarySearchTree<String>(obj);
		List<Node<String>> ls = bst.sortedOrder();
		List<String> expectedResult = new ArrayList<String>();
		expectedResult.add("apple");
		expectedResult.add("cat");
		expectedResult.add("cricket");
		expectedResult.add("hi");
		expectedResult.add("mango");
		expectedResult.add("neck");
		expectedResult.add("nest");
		expectedResult.add("tarzan");
		expectedResult.add("zoo");
		for (int i = 0; i < ls.size(); i++) {
			assertEquals(expectedResult.get(i), ls.get(i).getKey());
		}

	}

	@Test
	public void testBetweenTwoKeys()
			throws  FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(new FileReader(filename));
		BinarySearchTree<String> bst = new BinarySearchTree<String>(obj);
		List<Node<String>> ls = bst.sortBetweenTwoKeyValue("nest", "zoo");
		List<String> expectedResult = new ArrayList<String>();
		expectedResult.add("nest");
		expectedResult.add("tarzan");
		expectedResult.add("zoo");
		for (int i = 0; i < ls.size(); i++) {
			assertEquals(expectedResult.get(i), ls.get(i).getKey());
		}

	}

	@Test
	public void testBetweenTwoKeysIgnoreCase()
			throws  FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(new FileReader(filename));
		BinarySearchTree<String> bst = new BinarySearchTree<String>(obj);
		List<Node<String>> ls = bst.sortBetweenTwoKeyValue("NEST", "ZOO");
		List<String> expectedResult = new ArrayList<String>();
		expectedResult.add("nest");
		expectedResult.add("tarzan");
		expectedResult.add("zoo");
		for (int i = 0; i < ls.size(); i++) {
			assertEquals(expectedResult.get(i), ls.get(i).getKey());
		}
	}

	@Test
	public void testBetweenTwoKeysOneKeyNotPresent()
			throws  FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(new FileReader(filename));
		BinarySearchTree<String> bst = new BinarySearchTree<String>(obj);
		List<Node<String>> ls = bst.sortBetweenTwoKeyValue("net", "zoo");
		List<String> expectedResult = new ArrayList<String>();
		expectedResult.add("tarzan");
		expectedResult.add("zoo");
		for (int i = 0; i < ls.size(); i++) {
			assertEquals(expectedResult.get(i), ls.get(i).getKey());
		}
	}

	@Test(expected = AssertionError.class)
	public void testBetweenTwoKeysInvalidOrder()
			throws  FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(new FileReader(filename));
		BinarySearchTree<String> bst = new BinarySearchTree<String>(obj);
		List<Node<String>> ls = bst.sortBetweenTwoKeyValue("zoo", "apple");
	}

	@Test(expected = AssertionError.class)
	public void testBetweenTwoKeysNullKey()
			throws  FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(new FileReader(filename));
		BinarySearchTree<String> bst = new BinarySearchTree<String>(obj);
		List<Node<String>> ls = bst.sortBetweenTwoKeyValue("", "ZOO");

	}

	@Test(expected = AssertionError.class)
	public void testBetweenTwoKeysInvalidKey()
			throws  FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(new FileReader(filename));
		BinarySearchTree<String> bst = new BinarySearchTree<String>(obj);
		List<Node<String>> ls = bst.sortBetweenTwoKeyValue(null, "ZOO");

	}

	@Test
	public void testDeleteNode() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(new FileReader(filename));
		BinarySearchTree<String> bst = new BinarySearchTree<String>(obj);
		TreeNode<String> t = bst.deleteNode("tarzan");
		assertEquals("hi", t.getData().getKey());

	}

	@Test(expected = AssertionError.class)
	public void testDeleteNodeInvalidEntry() throws  FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(new FileReader(filename));
		BinarySearchTree<String> bst = new BinarySearchTree<String>(obj);
		TreeNode<String> t = bst.deleteNode("abcd");
	}

	@Test(expected = AssertionError.class)
	public void testDeleteNodeNullEntry() throws  FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(new FileReader(filename));
		BinarySearchTree<String> bst = new BinarySearchTree<String>(obj);
		TreeNode<String> t = bst.deleteNode(" ");

	}
	
}
