package sparse;

import static org.junit.Assert.*;

import org.junit.Test;

public class SparseMatrixOperationTest {

	@Test
	public void transposePositiveTest() {
		SparseMatrixOperation sparseMatrix = new SparseMatrixOperation(
				new int[][] { { 0, 4, 0 }, { 1, 0, 0 }, { 0, 0, 5 } });
		int transposeResult[][] = { { 0, 1, 0 }, { 4, 0, 0 }, { 0, 0, 5 } };
		assertArrayEquals(transposeResult, sparseMatrix.transpose());
	}

	@Test
	public void isSymmetricPositiveTest() {
		SparseMatrixOperation sparseMatrix = new SparseMatrixOperation(
				new int[][] { { 4, 0, 0 }, { 0, 1, 0 }, { 0, 0, 5 } });
		assertEquals(true, sparseMatrix.isSymmetric());
	}

	@Test
	public void isSymmetricNegativeTest() {
		SparseMatrixOperation sparseMatrix = new SparseMatrixOperation(
				new int[][] { { 0, 4, 0 }, { 1, 0, 0 }, { 0, 0, 5 } });
		assertEquals(false, sparseMatrix.isSymmetric());
	}

	@Test
	public void addPositiveTest() {
		int matrix1[][] = { { 0, 4, 0 }, { 1, 0, 0 }, { 0, 0, 5 } };
		int matrix2[][] = { { 0, 1, 0 }, { 4, 0, 0 }, { 0, 0, 5 } };
		int addResult[][] = { { 0, 5, 0 }, { 5, 0, 0 }, { 0, 0, 10 } };
		assertArrayEquals(addResult,
				SparseMatrixOperation.add(matrix1, matrix2));
	}

	@Test
	public void addAnotherPositiveTest() {
		int matrix1[][] = { { 0, 4, 0 }, { 1, 0, 0 }, { 2, 0, 5 } };
		int matrix2[][] = { { 0, 1, 0 }, { 4, 0, 8 }, { 0, 0, 5 } };
		int addResult[][] = { { 0, 5, 0 }, { 5, 0, 8 }, { 2, 0, 10 } };
		assertArrayEquals(addResult,
				SparseMatrixOperation.add(matrix1, matrix2));
	}

	@Test(expected = AssertionError.class)
	public void addNegativeTest() {
		int matrix1[][] = { { 0, 4, 0, 9 }, { 1, 0, 0, 6 }, { 2, 0, 5, 8 } };
		int matrix2[][] = { { 0, 1, 0 }, { 4, 0, 8 }, { 0, 0, 5 } };
		int addResult[][] = { { 0, 5, 0 }, { 5, 0, 8 }, { 2, 0, 10 } };
		assertArrayEquals(addResult,
				SparseMatrixOperation.add(matrix1, matrix2));
	}

	@Test
	public void multiplyPositiveTest() {
		int matrix1[][] = { { 0, 4, 0 }, { 1, 0, 0 }, { 2, 0, 5 } };
		int matrix2[][] = { { 0, 1, 0 }, { 4, 0, 8 }, { 0, 0, 5 } };
		int multiplyResult[][] = { { 16, 0, 32 }, { 0, 1, 0 }, { 0, 2, 25 } };
		assertArrayEquals(multiplyResult,
				SparseMatrixOperation.multiply(matrix1, matrix2));
	}

	@Test(expected = AssertionError.class)
	public void multiplyNegativeTest() {
		int matrix1[][] = { { 0, 4, 0, 9 }, { 1, 0, 0, 6 }, { 2, 0, 5, 8 } };
		int matrix2[][] = { { 0, 1, 0 }, { 4, 0, 8 }, { 0, 0, 5 } };
		int multiplyResult[][] = { { 16, 0, 32 }, { 0, 1, 0 }, { 0, 2, 25 } };
		assertEquals("unmatched matrices",
				SparseMatrixOperation.multiply(matrix1, matrix2));
	}
}