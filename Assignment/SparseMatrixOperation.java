package sparse;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * SparseMatrix is an immutable class for representing two-dimensional sparse
 * matrices
 * 
 * @author anmol
 * @since 26/1/2019
 * @version 1.0 It supports following methods 1.return transpose of the matrix
 *          2.check whether it is a symmetrical matrix 3.add two matrices
 *          4.multiply two matrices
 */
public final class SparseMatrixOperation {
	private ArrayList<ArrayList<Integer>> sparseMatrix = new ArrayList<ArrayList<Integer>>();
	private int normalMatrix[][];
	private int inputMatrix[][];
	private static final int SPARSE_COL = 3;

	/**
	 * SparseMatrix constructor that keeps a shallow copy of matrix input in
	 * inputMatrix and deep copy in normalMatrix
	 * 
	 * @param matrix
	 *            is the input matrix of 2d array of int
	 */
	public SparseMatrixOperation(int matrix[][]) {
		inputMatrix = matrix;
		normalMatrix = Arrays.copyOf(matrix, matrix.length);
		convertNormalToSparseMatrix();
	}

	/**
	 * converts normal matrix input to the sparse matrix format
	 */
	private void convertNormalToSparseMatrix() {
		sparseMatrix = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < normalMatrix.length; i++)
			for (int j = 0; j < normalMatrix[i].length; j++)
				if (normalMatrix[i][j] != 0)
					sparseMatrix.add(new ArrayList<Integer>(Arrays.asList(i, j,
							normalMatrix[i][j])));
	}

	/**
	 * converts our sparse matrix to the normal matrix for user readability
	 */
	private void convertSparseToNormalMatrix() {
		normalMatrix = new int[normalMatrix.length][normalMatrix[0].length];
		for (int i = 0; i < sparseMatrix.size(); i++) {
			normalMatrix[sparseMatrix.get(i).get(0)][sparseMatrix.get(i).get(1)] = sparseMatrix
					.get(i).get(2);
		}
	}

	/**
	 * calculates the transpose of the matrix
	 * 
	 * @return the matrix which is transpose of original matrix
	 */
	public int[][] transpose() {
		for (int i = 0; i < sparseMatrix.size(); i++) {
			int rowValue = sparseMatrix.get(i).get(0);
			sparseMatrix.get(i).set(0, sparseMatrix.get(i).get(1));
			sparseMatrix.get(i).set(1, rowValue);
		}
		convertSparseToNormalMatrix();
		return normalMatrix;
	}

	/**
	 * checks if the matrix entered is symmetric or not
	 * 
	 * @return true if the matrix entered is symmetric otherwise returns false
	 */
	public Boolean isSymmetric() {
		for (int i = 0; i < sparseMatrix.size(); i++)
			if (inputMatrix[sparseMatrix.get(i).get(0)][sparseMatrix.get(i)
					.get(1)] != inputMatrix[sparseMatrix.get(i).get(1)][sparseMatrix
					.get(i).get(0)])
				return false;
		return true;
	}

	/**
	 * calculates the addition of two sparse matrices
	 * 
	 * @param inputMatrix1
	 *            as first input matrix of 2d array of int to be added
	 * @param inputMatrix2
	 *            as second input matrix of 2d array of int to add to
	 * @return resultant matrix which is addition of matrix1 and matrix2 if the
	 *         dimensions are same
	 */
	public static int[][] add(int inputMatrix1[][], int inputMatrix2[][]) {
		SparseMatrixOperation sparseMatrixOne = new SparseMatrixOperation(
				inputMatrix1);
		SparseMatrixOperation sparseMatrixtwo = new SparseMatrixOperation(
				inputMatrix2);
		if (sparseMatrixOne.inputMatrix.length == sparseMatrixtwo.inputMatrix.length
				&& sparseMatrixOne.inputMatrix[0].length == sparseMatrixtwo.inputMatrix[0].length) {
			int resultMatrix[][] = new int[sparseMatrixOne.inputMatrix.length][sparseMatrixOne.inputMatrix[0].length];
			for (int i = 0; i < sparseMatrixOne.sparseMatrix.size(); i++) {
				resultMatrix[sparseMatrixOne.sparseMatrix.get(i).get(0)][sparseMatrixOne.sparseMatrix
						.get(i).get(1)] = sparseMatrixOne.sparseMatrix.get(i)
						.get(2);
			}
			for (int i = 0; i < sparseMatrixtwo.sparseMatrix.size(); i++) {
				resultMatrix[sparseMatrixtwo.sparseMatrix.get(i).get(0)][sparseMatrixtwo.sparseMatrix
						.get(i).get(1)] += sparseMatrixtwo.sparseMatrix.get(i)
						.get(2);
			}
			return resultMatrix;
		} else {
			throw new AssertionError();
		}
	}

	/**
	 * multiplies two sparse matrices
	 * 
	 * @param matrix1
	 *            integer 2d array as multiplier
	 * @param matrix2
	 *            integer 2d array as multiplicand
	 * @return resultant matrix which is multiplication of two given matrices if
	 *         number of columns of first matrix are equal to number of rows of
	 *         second matrix
	 */
	public static int[][] multiply(int inputMatrix1[][], int inputMatrix2[][]) {
		SparseMatrixOperation sparseMatrixOne = new SparseMatrixOperation(
				inputMatrix1);
		SparseMatrixOperation sparseMatrixtwo = new SparseMatrixOperation(
				inputMatrix2);
		if (sparseMatrixOne.inputMatrix[0].length == sparseMatrixtwo.inputMatrix.length) {
			int resultMatrix[][] = new int[sparseMatrixOne.inputMatrix.length][sparseMatrixtwo.inputMatrix[0].length];
			sparseMatrixtwo.transpose();
			sparseMatrixtwo.convertNormalToSparseMatrix();
			for (int i = 0; i < sparseMatrixOne.sparseMatrix.size(); i++)
				for (int j = 0; j < sparseMatrixtwo.sparseMatrix.size(); j++)
					if (sparseMatrixOne.sparseMatrix.get(i).get(1) == sparseMatrixtwo.sparseMatrix
							.get(j).get(1))
						resultMatrix[sparseMatrixOne.sparseMatrix.get(i).get(0)][sparseMatrixtwo.sparseMatrix
								.get(j).get(0)] += sparseMatrixOne.sparseMatrix
								.get(i).get(2)
								* sparseMatrixtwo.sparseMatrix.get(j).get(2);
			return resultMatrix;
		}
		throw new AssertionError();
	}
}