package com.metacube.training.question2;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniqueCharacterTest {

	
	UniqueCharacters count = new UniqueCharacters();

	@Test
	public void testOnlyCharacters() {
		int result = count.countUniqueCharacters("abcde");
		assertEquals(5,result);
	}
	
	@Test
	public void testCharactersAndNumbersAndSpecialCharacters() {
		int result = count.countUniqueCharacters("abcde@123");
		assertEquals(9,result);
	}
	
	@Test
	public void testCharactersAndNumbersAndSpecialCharactersWithSpace() {
		int result = count.countUniqueCharacters("abcde @123");
		assertEquals(9,result);
	}
	
	@Test(expected = AssertionError.class)
	public void testNullString() {
		int result = count.countUniqueCharacters(null);
		
	}
	
	@Test(expected = AssertionError.class)
	public void testEmptyString() {
		int result = count.countUniqueCharacters(" ");
	}
}
