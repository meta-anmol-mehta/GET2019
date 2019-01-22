import static org.junit.Assert.*;

import org.junit.Test;

public class ArrOperationTest {

	@Test(expected = AssertionError.class)
	public void maxMirrorTest1() {

		int[] arrayOfNumbers = {};

		ArrOperation operation = new ArrOperation(arrayOfNumbers);

		assertEquals(3, operation.maxMirrorSection());

	}

	@Test
	public void maxMirrorTest2() {

		int[] arrayOfNumbers = { 7, 1, 4, 9, 7, 4, 1 };

		ArrOperation operation = new ArrOperation(arrayOfNumbers);

		assertEquals(2, operation.maxMirrorSection());

	}

	@Test
	public void maxMirrorTest3() {

		int[] arrayOfNumbers = { 1, 4, 5, 3, 5, 4, 1 };

		ArrOperation operation = new ArrOperation(arrayOfNumbers);

		assertEquals(7, operation.maxMirrorSection());

	}

	@Test
	public void maxMirrorTest4() {

		int[] arrayOfNumbers = { 1, 2, 1, 4 };

		ArrOperation operation = new ArrOperation(arrayOfNumbers);

		assertEquals(3, operation.maxMirrorSection());

	}

	@Test
	public void countClumpsTest1() {

		int[] arrayOfNumbers = { 1, 2, 2, 3, 4, 4 };

		ArrOperation operation = new ArrOperation(arrayOfNumbers);

		assertEquals(2, operation.countClumps());

	}

	@Test(expected = AssertionError.class)
	public void countClumpsTest2() {

		int[] arrayOfNumbers = {};

		ArrOperation operation = new ArrOperation(arrayOfNumbers);

		assertEquals(2, operation.countClumps());

	}

	@Test
	public void countClumpsTest3() {

		int[] arrayOfNumbers = { 1, 1, 1, 1, 1 };

		ArrOperation operation = new ArrOperation(arrayOfNumbers);

		assertEquals(1, operation.countClumps());

	}

	@Test
	public void fixXyTest1() {

		int[] arrayOfNumbers = { 5, 4, 9, 4, 9, 5 };
		int[] expected = { 9, 4, 5, 4, 5, 9 };

		ArrOperation operation = new ArrOperation(arrayOfNumbers);

		assertArrayEquals(expected, operation.fixXy(4, 5));

	}

	@Test(expected = AssertionError.class)
	public void fixXyTest2() {

		int[] arrayOfNumbers = {};
		int[] expected = { 1, 4, 5, 1 };

		ArrOperation operation = new ArrOperation(arrayOfNumbers);

		assertArrayEquals(expected, operation.fixXy(4, 5));

	}

	@Test
	public void fixXyTest3() {

		int[] arrayOfNumbers = { 1, 4, 1, 5, 5, 4, 1 };

		int[] expected = { 1, 4, 5, 1, 1, 4, 5 };

		ArrOperation operation = new ArrOperation(arrayOfNumbers);

		assertArrayEquals(expected, operation.fixXy(4, 5));

	}

	@Test
	public void splitArrayTest1() {

		int[] arrayOfNumbers = { 1, 1, 1, 2, 1 };

		ArrOperation operation = new ArrOperation(arrayOfNumbers);

		assertEquals(3, operation.splitArray());

	}

	@Test
	public void splitArrayTest2() {

		int[] arrayOfNumbers = { 2, 1, 1, 2, 1 };

		ArrOperation operation = new ArrOperation(arrayOfNumbers);

		assertEquals(-1, operation.splitArray());

	}

	@Test(expected = AssertionError.class)
	public void splitArrayTest3() {

		int[] arrayOfNumbers = {};

		ArrOperation operation = new ArrOperation(arrayOfNumbers);

		assertEquals(1, operation.splitArray());

	}

}
