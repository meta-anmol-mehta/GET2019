import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Main {

	@Test
	public void postiveTestIsMember() {

		int[] inputArray = { 20, 40, 60, 80, 100, 120 };
		IntSet inputSet = new IntSet(inputArray);
		;
		assertEquals(true, inputSet.isMember(60));

	}

	@Test
	public void postiveTestSize() {

		int[] inputArray = { 20, 40, 60, 80, 100, 120 };
		IntSet inputSet = new IntSet(inputArray);
		assertEquals(6, inputSet.setSize());

	}

	@Test
	public void postiveTestIsSubSet() {

		int[] inputArray = { 20, 40, 60, 80, 100, 120 };
		IntSet inputSet = new IntSet(inputArray);
		int[] anotherArray = { 40, 60, 80 };
		IntSet anotherSet = new IntSet(anotherArray);
		assertEquals(true, inputSet.isSubSet(anotherSet));

	}

	@Test(expected = AssertionError.class)
	public void negativeTestComplement() {

		int[] inputArray = {};
		IntSet inputSet = new IntSet(inputArray);

		int[] expectedArray = { 980, 960, 940 };
		assertArrayEquals(expectedArray, inputSet.complementedSet());

	}

	@Test(expected = AssertionError.class)
	public void negativeTestestUnion() {

		int[] inputArray = {};
		IntSet inputSet1 = new IntSet(inputArray);

		int[] inputArray2 = { 20, 40, 60 };
		IntSet inputSet2 = new IntSet(inputArray2);
		Object[] expectedArray = { 20, 40, 60 };
		assertArrayEquals(expectedArray, inputSet1.unionOfSet(inputSet2)
				.toArray());

	}

	@Test(expected = AssertionError.class)
	public void negativeTestestIsMember2() {

		int[] inputArray = {};
		IntSet inputSet = new IntSet(inputArray);
		;
		assertEquals(true, inputSet.isMember(60));

	}

	@Test(expected = AssertionError.class)
	public void negativeTestestSize2() {

		int[] inputArray = {};
		IntSet inputSet = new IntSet(inputArray);
		assertEquals(6, inputSet.setSize());

	}

	@Test(expected = AssertionError.class)
	public void negativeTestIsSubSet2() {

		int[] inputArray = {};
		IntSet inputSet = new IntSet(inputArray);
		int[] anotherArray = { 40, 60, 80 };
		IntSet anotherSet = new IntSet(anotherArray);
		assertEquals(true, inputSet.isSubSet(anotherSet));

	}

	@Test
	public void postiveTestUnion2() {

		int[] inputArray = { 20, 40, 60 };
		IntSet inputSet1 = new IntSet(inputArray);

		int[] inputArray2 = { 20, 40, 60 };
		IntSet inputSet2 = new IntSet(inputArray2);
		Object[] expectedArray = { 20, 40, 60 };
		assertArrayEquals(expectedArray, inputSet1.unionOfSet(inputSet2)
				.toArray());

	}

	@Test
	public void postiveTestevaluate() {

		int[] inputCoefficient = { 6, 4, 2 };

		Polynomial inputPolynomial = new Polynomial(inputCoefficient);
		assertEquals((float) 22.0, inputPolynomial.evaluate((float) 2.0),
				(float) 0.0);

	}

	@Test
	public void postiveTestDegree() {

		int[] inputCoefficient = { 6, 4, 2 };

		Polynomial inputPolynomial = new Polynomial(inputCoefficient);
		assertEquals(2, inputPolynomial.degree());

	}

	@Test
	public void postiveTestAdd() {

		int[] inputCoefficient = { 6, 4, 2 };
		int[] anotherCoefficient = { 6, 0, 4, 2 };

		String sum = "2x^3+6x^2+4x^1+12";

		Polynomial inputPolynomial = new Polynomial(inputCoefficient);
		Polynomial anotherPolynomial = new Polynomial(anotherCoefficient);
		assertEquals(sum, inputPolynomial.addPolynomial(anotherPolynomial));

	}

	@Test
	public void postiveTestmultiply() {

		int[] inputCoefficient = { 5, 0, 10, 6 };
		int[] anotherCoefficient = { 1, 2, 4 };

		String multiply = "24x^5+52x^4+26x^3+30x^2+10x^1+5";

		Polynomial inputPolynomial = new Polynomial(inputCoefficient);
		Polynomial anotherPolynomial = new Polynomial(anotherCoefficient);
		assertEquals(multiply,
				inputPolynomial.multiPolynomial(anotherPolynomial));

	}

	@Test(expected = AssertionError.class)
	public void negativeTestevaluate() {

		int[] inputCoefficient = {};

		Polynomial inputPolynomial = new Polynomial(inputCoefficient);
		assertEquals((float) 22.0, inputPolynomial.evaluate((float) 2.0),
				(float) 0.0);

	}

	@Test(expected = AssertionError.class)
	public void negativeTestDegree() {

		int[] inputCoefficient = {};

		Polynomial inputPolynomial = new Polynomial(inputCoefficient);
		assertEquals(2, inputPolynomial.degree());

	}

	@Test(expected = AssertionError.class)
	public void negativeTestAdd() {

		int[] inputCoefficient = {};
		int[] anotherCoefficient = { 6, 0, 4, 2 };

		String sum = "2x^3+6x^2+4x^1+12";

		Polynomial inputPolynomial = new Polynomial(inputCoefficient);
		Polynomial anotherPolynomial = new Polynomial(anotherCoefficient);
		assertEquals(sum, inputPolynomial.addPolynomial(anotherPolynomial));

	}

	@Test(expected = AssertionError.class)
	public void negativeTestmultiply() {

		int[] inputCoefficient = {};
		int[] anotherCoefficient = { 1, 2, 4 };

		String multiply = "24x^5+52x^4+26x^3+30x^2+10x^1+5";

		Polynomial inputPolynomial = new Polynomial(inputCoefficient);
		Polynomial anotherPolynomial = new Polynomial(anotherCoefficient);

		assertEquals(multiply,
				inputPolynomial.multiPolynomial(anotherPolynomial));

	}
}