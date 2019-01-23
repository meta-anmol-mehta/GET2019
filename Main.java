import static org.junit.Assert.*;

import org.junit.Test;

public class Main {

	@Test
	public void testHCF1() {

		int num1 = 366;
		int num2 = 60;

		NumberCalculations calculation = new NumberCalculations();

		assertEquals(6, calculation.calculateHCF(num1, num2));

	}

	@Test
	public void testHCF2() {

		int num1 = 18;
		int num2 = 12;

		NumberCalculations calculation = new NumberCalculations();

		assertEquals(6, calculation.calculateHCF(num1, num2));

	}

	@Test
	public void testHCF3() {

		int num1 = 0;
		int num2 = 50;

		NumberCalculations calculation = new NumberCalculations();

		assertEquals(50, calculation.calculateHCF(num1, num2));

	}

	@Test(expected = ArithmeticException.class)
	public void testHCF4() {

		int num1 = 366;
		int num2 = 0;

		NumberCalculations calculation = new NumberCalculations();

		assertEquals(0, calculation.calculateHCF(num1, num2));

	}

	@Test
	public void testLCM1() {

		int num1 = 45;
		int num2 = 75;

		NumberCalculations calculation = new NumberCalculations();

		assertEquals(225, calculation.calculateLCM(num1, num2));

	}

	@Test(expected = ArithmeticException.class)
	public void testLCM2() {

		int num1 = 0;
		int num2 = 75;

		NumberCalculations calculation = new NumberCalculations();

		assertEquals(225, calculation.calculateLCM(num1, num2));

	}

	@Test(expected = ArithmeticException.class)
	public void testLCM3() {

		int num1 = 45;
		int num2 = 0;

		NumberCalculations calculation = new NumberCalculations();

		assertEquals(225, calculation.calculateLCM(num1, num2));

	}

	@Test
	public void testLCM4() {

		int num1 = 18;
		int num2 = 12;

		NumberCalculations calculation = new NumberCalculations();

		assertEquals(36, calculation.calculateLCM(num1, num2));

	}

	@Test
	public void testLinearSearch1() {

		int[] inputArray = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int searchElement = 12;

		SearchFunc searching = new SearchFunc();

		assertEquals(-1, searching.linearSearch(7, inputArray, searchElement));

	}

	@Test
	public void testLinearSearch2() {

		int[] inputArray = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int searchElement = 5;

		SearchFunc searching = new SearchFunc();

		assertEquals(4, searching.linearSearch(7, inputArray, searchElement));

	}

	@Test
	public void testLinearSearch3() {

		int[] inputArray = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int searchElement = 5;

		SearchFunc searching = new SearchFunc();

		assertEquals(4, searching.linearSearch(7, inputArray, searchElement));

	}

	@Test(expected = AssertionError.class)
	public void testBinarySearch1() {

		int[] inputArray = {};
		int searchElement = 15;

		SearchFunc searching = new SearchFunc();

		assertEquals(-1, searching.binarySearch(0, 7, inputArray, searchElement));

	}

	@Test
	public void testBinarySearch2() {

		int[] inputArray = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int searchElement = 5;

		SearchFunc searching = new SearchFunc();

		assertEquals(4, searching.binarySearch(0, 7, inputArray, searchElement));

	}

	@Test(expected = AssertionError.class)
	public void testBinarySearch3() {

		int[] inputArray = {};
		int searchElement = 5;

		SearchFunc searching = new SearchFunc();

		assertEquals(4, searching.binarySearch(0, 7, inputArray, searchElement));

	}

	@Test
	public void testNQueen1() {

		int[][] queenMatrix = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		int matrixDimension = 4;

		QueensProblem queenProb = new QueensProblem(matrixDimension);
		assertEquals(true, queenProb.solveNQ(queenMatrix, 0));
	}

	@Test(expected = AssertionError.class)
	public void testNQueen2() {

		int[][] queenMatrix = {};
		int matrixDimension = 4;

		QueensProblem queenProb = new QueensProblem(matrixDimension);
		assertEquals(true, queenProb.solveNQ(queenMatrix, 0));
	}

	@Test(expected = AssertionError.class)
	public void testNQueen3() {

		int[][] queenMatrix = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		int matrixDimension = 3;

		QueensProblem queenProb = new QueensProblem(matrixDimension);
		assertEquals(true, queenProb.solveNQ(queenMatrix, 0));
	}

	@Test
	public void test() {

		int matrixDimension = 8;

		KnightProblem knight = new KnightProblem(matrixDimension);
		assertEquals(true, knight.solve());
	}
}
